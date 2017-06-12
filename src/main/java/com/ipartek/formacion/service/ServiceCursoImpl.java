package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.DAOCurso;

/**
 * Servicio del curso
 * @author Curso
 *
 */
@Service(value = "serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	@Autowired()
	private DAOCurso daoCurso;
	
	@Override()
	public List<Curso> listar() {
		return this.daoCurso.getAll();
	}

	@Override()
	public List<Curso> listarUltimos() {
		return this.daoCurso.getLastTen();
	}
	
	@Override()
	public List<Curso> buscar(String valor) {
		return this.daoCurso.search(valor);
	}
	
	@Override()
	public Curso buscarPorId(long id) {
		return this.daoCurso.getById(id);
	}

	@Override()
	public boolean crear(Curso c) {
		return this.daoCurso.insert(c);
	}

	@Override()
	public boolean modificar(Curso c) {
		return this.daoCurso.update(c);
	}

	@Override()
	public boolean eliminar(long id) {
		return this.daoCurso.delete(id);
	}
	
	@Override()
	public int contar() {
		return this.daoCurso.count();
	}
}
