package ar.com.sgilberto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgilberto.model.LibroDto;
import ar.com.sgilberto.service.ILibroService;

@Controller
@RequestMapping("biblioteca")
public class BibliotecaController {

	@Autowired
	private ILibroService libroService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(Model model) {

		model.addAttribute("LibroDto", new LibroDto());
		
		List<LibroDto> libros = new ArrayList<LibroDto>();
		libros = this.getLibros();

		model.addAttribute("libros", libros);
		
		if(libros.size() < 0) {
			model.addAttribute("errorMessage", "No se encontraron resultados");
		}
			
		return new ModelAndView("biblioteca");
	}

	// obtener todos los libros de la base
	public List<LibroDto> getLibros() {

		List<LibroDto> libros = this.libroService.getLibros();
		
		return libros;

	}

	// Agregar un nuevo libro
	@RequestMapping(value = "/addLibro", method = RequestMethod.POST)
	public ModelAndView addLibro(@ModelAttribute LibroDto libro, Model model, HttpServletRequest request) {

		this.libroService.addLibro(libro);
		
		return new ModelAndView("redirect:/biblioteca");
	}

	// borrar libro
	@RequestMapping(value = "/removeLibro/{id}", method = RequestMethod.POST)
	public boolean removeLibro(@PathVariable Integer id, Model model, HttpServletRequest request) {

		this.libroService.removeLibro(id);
		
		return true;
	}
	
	// ver detalle de un libro
	@RequestMapping(value = "/detalle{id}", method = RequestMethod.GET)
	public ModelAndView verDetalle(@PathVariable("id") String id, Model model, HttpServletRequest request) {

		return new ModelAndView("detalle");
	}
	
	

}