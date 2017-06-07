package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso c = new Curso();

		c.setNombre(rs.getString("nom_curso"));
		c.setCod(rs.getString("cod_curso"));
		return c;
	}

}