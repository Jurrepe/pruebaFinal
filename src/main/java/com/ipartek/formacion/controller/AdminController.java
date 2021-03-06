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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

	private static final int COD_CURSO = 8;
	
	@Autowired()
	private ServiceCurso serviceCurso;
	
	/**
	 * Pagina principal
	 * @param model modelo
	 * @param msg mensaje
	 * @return pagina principal
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model, @RequestParam(value="msg", required=false) String msg) {
		
		model.addAttribute("msg", msg);
		model.addAttribute("cursos",this.serviceCurso.listar());
		model.addAttribute("total",this.serviceCurso.contar());
		
		return "/admin/index";
	}
	
	/**
	 * Pagina migracion
	 * @param model modelo
	 * @return pagina migracion
	 */
	@RequestMapping(value = "/admin/curso/migracion", method = RequestMethod.GET)
	public String migracion(Model model) {

		return "admin/migracion";
	}

	/**
	 * Migra los datos a la SQL
	 * @param model modelo
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
               System.out.println(nextLine[1] + nextLine[COD_CURSO] );
               curso.setNombre(nextLine[1]);
               curso.setCod(nextLine[COD_CURSO]);
               if (!"".equals(curso.getNombre()) && !"".equals(curso.getCod())) {
            	   this.serviceCurso.crear(curso);
            	   contador++;
               }
            }
            reader.close();
            msg = "Cursos leidos correctamente. Se han a�adido " + contador + " cursos nuevos";

        } catch (FileNotFoundException e) {
        	msg = "No se encuentra el archivo en la ubicaci�n adecuada";
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
	 * @param model modelo
	 * @return vista editar
	 */
	@RequestMapping(value = "/admin/curso/edit", method = RequestMethod.GET)
	public String formularioCrear(Model model) {

		model.addAttribute("curso", new Curso());
		return "admin/form";
	}

	/**
	 * Vista edicion de un curso especifico
	 * @param model modelo
	 * @param id curso
	 * @return detalles de un curso especifico
	 */
	@RequestMapping(value = "/admin/curso/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(Model model, @PathVariable() int id) {

		model.addAttribute("curso", this.serviceCurso.buscarPorId(id));
		return "admin/form";
	}

	/**
	 * Inserta un curso
	 * @param model modelo
	 * @param c clase curso
	 * @param bindingResult validador
	 * @return pagina de inicio del admin con msg
	 */
	@RequestMapping(value = "/admin/curso/crear", method = RequestMethod.POST)
	public String crear(Model model,@Valid() Curso c, BindingResult bindingResult) {

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
		model.addAttribute("total",this.serviceCurso.contar());
		return "redirect: ../../admin";
	}

	/**
	 * Eliminar un curso
	 * @param model modelo
	 * @param id id curso
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
		model.addAttribute("total",this.serviceCurso.contar());
		return "admin/index";
	}
	
}
