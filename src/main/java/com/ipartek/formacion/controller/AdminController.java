package com.ipartek.formacion.controller;



import java.io.FileNotFoundException;
import java.io.FileReader;

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
import com.opencsv.CSVReader;


/**
 * Controlador del curso
 * @author Curso
 *
 */
@Controller()
public class AdminController {

	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**
	 * Pagina principal
	 * @param model
	 * @return pagina principal
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("cursos",serviceCurso.listar());
		model.addAttribute("total",serviceCurso.contar());
		return "/admin/index";
	}
	
	/**
	 * Pagina migracion
	 * @param model
	 * @return pagina migracion
	 */
	@RequestMapping(value = "/admin/curso/migracion", method = RequestMethod.GET)
	public String migracion(Model model) {

		return "admin/migracion";
	}

	/**
	 * Migra los datos a la SQL
	 * @param model
	 * @return pagina migracion con mensaje
	 */
	@RequestMapping(value = "/admin/curso/migrar", method = RequestMethod.GET)
	public String migrando(Model model) {
		
		String csvFile = "c:/desarrollo/datos/cursos.csv";
		String msg = "";
        try {

            CSVReader reader = new CSVReader(new FileReader(csvFile),';');
            String [] nextLine;
            Curso curso = new Curso();
            int contador = 0;
            while ((nextLine = reader.readNext()) != null) {
               System.out.println(nextLine[1] + nextLine[8] );
               curso.setNombre(nextLine[1]);
               curso.setCod(nextLine[8]);
               if (!"".equals(curso.getNombre()) && !"".equals(curso.getCod())) {
            	   serviceCurso.crear(curso);
            	   contador++;
               }
            }
            reader.close();
            msg = "Cursos leidos correctamente. Se han añadido " + contador + " cursos nuevos";

        } catch (FileNotFoundException e) {
        	msg = "No se encuentra el archivo en la ubicación adecuada";
            e.printStackTrace();
        } catch (Exception e) {
        	msg = "Error interno al intentar migrar";
            e.printStackTrace();
        }
        model.addAttribute("msg", msg);
		return "admin/migracion";
	}
	
	/**
	 * Vista edicion de un curso
	 * @param model
	 * @return vista editar
	 */
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}

	/**
	 * Vista edicion de un curso especifico
	 * @param model
	 * @param id
	 * @return detalles de un curso especifico
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "admin/form";
	}

	/**
	 * Inserta un curso
	 * @param model
	 * @param c
	 * @param bindingResult
	 * @return pagina de inicio del admin con msg
	 */
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
		model.addAttribute("total",serviceCurso.contar());
		return "admin/index";
	}

	/**
	 * Eliminar un curso
	 * @param model
	 * @param id
	 * @return pagina de inicio del admin con msg
	 */
	@RequestMapping(value = "/admin/curso/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(Model model, @PathVariable() int id) {
		String msg = "Error al eliminar el curso";
		if (this.serviceCurso.eliminar(id)) {
			msg = "Curso eliminado correctamente";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("curso", new Curso());
		model.addAttribute("cursos", this.serviceCurso.listar());
		model.addAttribute("total",serviceCurso.contar());
		return "admin/index";
	}
	
}
