package com.ipartek.formacion.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.ServiceCurso;

/**
 * Controlador de la Api
 * @author Curso
 *
 */
@Controller()
@RequestMapping(value = "api/curso/")
public class ApiCursoController {

	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**Filtra la lista de los resultados
	 * 
	 * @param filtro
	 * @return Array de cursos del resultado de la busqueda
	 */
	@RequestMapping(
			value="",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody() ArrayList<Curso> buscarCursos(
			@RequestParam(value = "filtro", required = true) String filtro)
	{

		ArrayList<Curso> cursos = null;
		if (filtro != null){
			cursos = (ArrayList<Curso>) this.serviceCurso.buscar(filtro);
		} 
		return cursos;
	}
	
}
