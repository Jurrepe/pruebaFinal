package com.ipartek.formacion.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
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
	
	@RequestMapping(value = "/admin/curso/migracion", method = RequestMethod.GET)
	public String migracion(Model model) {


		return "admin/migracion";
	}

	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}


	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "admin/form";
	}


	@RequestMapping(value = "/admin/curso/crear", method = RequestMethod.POST)
	public String crear(Model model,@Valid Curso c, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
            return "admin/form";
        }
		String msg = "Error al modificar/crear Curso";
		if (c.getId() == -1) {
			this.serviceCurso.crear(c);
			msg = "Curso creado con exito";
		} else {
			this.serviceCurso.modificar(c);
			msg = "Curso modificado con exito";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "admin/index";
	}


	@RequestMapping(value = "/admin/curso/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(Model model, @PathVariable() int id) {
		String msg = "Error al eliminar el curso";
		if (this.serviceCurso.eliminar(id)) {
			msg = "Curso eliminado correctamente";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("curso", new Curso());
		model.addAttribute("cursos", this.serviceCurso.listar());
		return "admin/index";
	}
	
}
