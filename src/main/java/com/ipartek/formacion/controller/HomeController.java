package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceCurso;

/**
 * Pagina principal
 * @author Curso
 *
 */
@Controller()
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**
	 * Controlador vista principal
	 * @param locale
	 * @param model
	 * @return home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("cursos", serviceCurso.listarUltimos());
		
		return "home";
	}
	
	/**
	 * Controlador vista detalle no editable
	 * @param id
	 * @param model
	 * @return vista detalle
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String irFormularioEditar(@PathVariable int id, Model model) {

		model.addAttribute("curso", serviceCurso.buscarPorId(id));
		return "view";
	}

}
