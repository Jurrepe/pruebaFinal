package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

/**
 * DAO del curso
 * @author Curso
 *
 */
public interface DAOCurso {

	/**
	 * Datasource para la bbdd
	 * @param ds datasource
	 */
	void setDatasource(DataSource ds);

	/**
	 * Lista los ultimos 500 cursos
	 * @return lista de cursos
	 */
	List<Curso> getAll();

	/**
	 * Coge un curso por id
	 * @param id curso 
	 * @return curso
	 */
	Curso getById(long id);

	/**
	 * Inserta un curso nuevo en la bbdd
	 * @param c curso
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean insert(Curso c);

	/**
	 * Modifica un curso
	 * @param c curos 
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean update(Curso c);

	/**
	 * elimina un curso
	 * @param id curso 
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean delete(long id);

	/**
	 * Coge los ultimos 10 cursos de la lista
	 * @return lista de cursos
	 */
	List<Curso> getLastTen();

	/**
	 * Busca por nombre o codigo del curso
	 * @param value texto a buscar
	 * @return lista de cursos
	 */
	List<Curso> search(String value);

	/**
	 * Cuenta el numero de cursos en la bbdd
	 * @return entero
	 */
	int count();

}
