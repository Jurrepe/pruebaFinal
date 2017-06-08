package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.mapper.CursoMapper;

@Repository(value = "daoCurso")
public class DAOCursoImpl implements DAOCurso{

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	@Override()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	private static final String SQL_GET_ALL = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` WHERE `id` = ?";
	private static final String SQL_INSERT = "INSERT INTO `curso` (`nom_curso`, `cod_curso`) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE `curso` SET `nom_curso`= ?, `cod_curso`= ? WHERE `id`= ? ;";
	private static final String SQL_DELETE = "DELETE FROM `curso` WHERE `id` = ?;";
	private static final String SQL_GET_LAST_10 = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` ORDER BY `id` DESC LIMIT 10;";
	
	private static final String SQL_SEARCH = "SELECT `id`, `nom_curso`, `cod_curso` FROM `curso` WHERE nom_curso LIKE ? OR cod_curso LIKE ?  LIMIT 500;";
	
	@Override()
	public List<Curso> getAll() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		try {
			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen cursos todavia");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return lista;
	}

	@Override()
	public List<Curso> getLastTen() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		try {
			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_LAST_10, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen cursos todavia");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return lista;
	}
	
	@Override()
	public List<Curso> search(String value) {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		value = '%'+value+'%';
		try {
			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_SEARCH, new Object[] { value , value }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen cursos todavia");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return lista;
	}
	
	@Override()
	public Curso getById(long id) {
		Curso c = null;
		try {
			c = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existe el curso");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return c;
	}

	@Override()
	public boolean insert(final Curso c) {
		boolean resul = false;
		try {
			int affectedRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
				@Override()
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					final PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, c.getNombre());
					ps.setString(2, c.getCod());
					return ps;
				}
			}, keyHolder);

			if (affectedRows == 1) {
				resul = true;
				c.setId(keyHolder.getKey().longValue());
			}

		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}

	@Override()
	public boolean update(Curso c) {
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = { c.getNombre(),c.getCod(), c.getId() };
			affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}

	@Override()
	public boolean delete(long id) {
		boolean resul = false;
		try {
			int affectedRows = this.jdbcTemplate.update(SQL_DELETE, id);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (DataIntegrityViolationException e) {
			this.logger.warn(e.getMessage());
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}
}
