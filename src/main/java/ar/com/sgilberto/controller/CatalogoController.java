package ar.com.sgilberto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgilberto.model.LibroDto;
import ar.com.sgilberto.service.LibroService;

@Controller
@RequestMapping("catalogo")
public class CatalogoController {

	@Autowired
	private LibroService libroService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(Model model) {

		model.addAttribute("LibroDto", new LibroDto());

		List<LibroDto> libros = this.libroService.getLibros();

		model.addAttribute("libros", libros);

		if (libros.size() < 0) {
			model.addAttribute("errorMessage", "No se encontraron resultados");
		}

		return new ModelAndView("catalogoUser");
	}

}