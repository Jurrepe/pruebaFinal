package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Curso;

public interface ServiceCurso {

	List<Curso> listar();

	Curso buscarPorId(long id);

	boolean crear(Curso c);

	boolean modificar(Curso c);
	
	boolean eliminar(long id);

	List<Curso> listarUltimos();

	List<Curso> buscar(String valor);


}
