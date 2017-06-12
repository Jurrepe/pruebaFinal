package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

public interface DAOCurso {

	void setDatasource(DataSource ds);

	List<Curso> getAll();

	Curso getById(long id);

	boolean insert(Curso c);

	boolean update(Curso c);

	boolean delete(long id);

	List<Curso> getLastTen();

	List<Curso> search(String value);

	int count();

}
