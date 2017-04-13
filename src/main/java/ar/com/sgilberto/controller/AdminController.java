package ar.com.sgilberto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgilberto.enumerator.TrxStatus;
import ar.com.sgilberto.model.LibroDto;
import ar.com.sgilberto.model.RespuestaJSON;
import ar.com.sgilberto.service.LibroService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private LibroService libroService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public ModelAndView adminLibros() {

		ModelAndView model = new ModelAndView();
		
		List<LibroDto> libros = this.libroService.getLibros();

		if (libros.size() < 0) {
			model.addObject("errorMessage", "No se encontraron resultados");
		}

		model.addObject("libros", libros);
		model.setViewName("catalogoAdmin");
			
		return model;

	}

	// Agregar un nuevo libro
	@RequestMapping(value = "/agregarLibro", method = RequestMethod.POST)
	public @ResponseBody RespuestaJSON addLibro(@ModelAttribute("libro") LibroDto libro, Model model,
			HttpServletRequest request) {

		try {
			this.libroService.addLibro(libro);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespuestaJSON("Ha ocurrido un error en el servidor", TrxStatus.ERROR);
		}

		return new RespuestaJSON("Libro agregado exitosamente", TrxStatus.SUCCESS);

	}

	// borrar libro
	@RequestMapping(value = "/eliminarLibro", method = RequestMethod.POST)
	public @ResponseBody RespuestaJSON removeLibro(@RequestParam("id") Integer id, Model model,
			HttpServletRequest request) {

		try {
			this.libroService.removeLibro(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespuestaJSON("Ha ocurrido un error en el servidor", TrxStatus.ERROR);
		}

		return new RespuestaJSON("Libro eliminado exitosamente", TrxStatus.SUCCESS);
	}

}