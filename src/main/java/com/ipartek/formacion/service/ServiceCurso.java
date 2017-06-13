package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Curso;

/**
 * Servicio curso
 * @author Curso
 *
 */
public interface ServiceCurso {

	/**
	 * Lista los ultimos 500 cursos
	 * @return lista de cursos
	 */
	List<Curso> listar();

	/**
	 * Coge un curso por id
	 * @param id curso 
	 * @return curso
	 */
	Curso buscarPorId(long id);

	/**
	 * Inserta un curso nuevo en la bbdd
	 * @param c curso
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean crear(Curso c);

	/**
	 * Modifica un curso
	 * @param c curos 
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean modificar(Curso c);
	
	/**
	 * elimina un curso
	 * @param id curso 
	 * @return true si lo inserta, false en caso contrario
	 */
	boolean eliminar(long id);

	/**
	 * Coge los ultimos 10 cursos de la lista
	 * @return lista de cursos
	 */
	List<Curso> listarUltimos();

	/**
	 * Busca por nombre o codigo del curso
	 * @param valor texto a buscar
	 * @return lista de cursos
	 */
	List<Curso> buscar(String valor);

	/**
	 * Cuenta el numero de cursos en la bbdd
	 * @return entero
	 */
	int contar();


}
