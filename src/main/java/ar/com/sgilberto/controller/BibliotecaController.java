package ar.com.sgilberto.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.sgilberto.model.LibroDto;
import ar.com.sgilberto.service.ILibroService;

@Controller
public class BibliotecaController {

	@Autowired
	private ILibroService libroService;

	// obtener todos los libros de la base
	@RequestMapping(value = "/biblioteca", method = RequestMethod.GET)
	public String getLibros(Model model, HttpServletRequest request, HttpServletResponse response) {

		List<LibroDto> libros = this.libroService.getLibros();

		model.addAttribute("libros", libros);

		return "libros";
	}

	// ver detalle de un libro
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String verDetalle(@ModelAttribute LibroDto libro, Model model, HttpServletRequest request) {

		return "detalle";
	}

}