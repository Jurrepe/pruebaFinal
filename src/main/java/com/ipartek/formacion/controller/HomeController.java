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
	
	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**
	 * Controlador vista principal
	 * @param model modelo
	 * @return home
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("cursos", this.serviceCurso.listarUltimos());
		
		return "home";
	}
	
	/**
	 * Controlador vista detalle no editable
	 * @param id curso
	 * @param model modelo
	 * @return vista detalle
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String irFormularioEditar(@PathVariable() int id, Model model) {

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "view";
	}

}
