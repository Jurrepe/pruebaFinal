package com.ipartek.formacion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceCurso;



@Controller()
public class AdminController {

	@Autowired()
	private ServiceCurso serviceCurso;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("cursos",serviceCurso.listar());
		
		return "/admin/index";
	}


}
