package ar.com.sgilberto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgilberto.enumerator.TrxStatus;
import ar.com.sgilberto.model.LibroDto;
import ar.com.sgilberto.model.RespuestaJSON;
import ar.com.sgilberto.service.ILibroService;

@Controller
@RequestMapping("catalogo")
public class CatalogoController {

	@Autowired
	private ILibroService libroService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView init(Model model) {

		model.addAttribute("LibroDto", new LibroDto());

		List<LibroDto> libros = new ArrayList<LibroDto>();
		libros = this.getLibros();

		model.addAttribute("libros", libros);

		if (libros.size() < 0) {
			model.addAttribute("errorMessage", "No se encontraron resultados");
		}

		return new ModelAndView("catalogo");
	}

	// obtener todos los libros de la base
	public List<LibroDto> getLibros() {

		List<LibroDto> libros = this.libroService.getLibros();

		return libros;

	}

	// Agregar un nuevo libro
	@RequestMapping(value = "/agregarLibro", method = RequestMethod.POST)
	public @ResponseBody RespuestaJSON addLibro(@ModelAttribute("libro") LibroDto libro, Model model, HttpServletRequest request) {

		try {
			this.libroService.addLibro(libro);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespuestaJSON("Ha ocurrido un error en el servidor", TrxStatus.ERROR);
		}

		return new RespuestaJSON("Libro agregado exitosamente", TrxStatus.SUCCESS);

	}

	// borrar libro
	@RequestMapping(value = "/eliminarLibro/{id}", method = RequestMethod.POST)
	public @ResponseBody RespuestaJSON removeLibro(@PathVariable Integer id, Model model, HttpServletRequest request) {

		try {
			this.libroService.removeLibro(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespuestaJSON("Ha ocurrido un error en el servidor", TrxStatus.ERROR);
		}

		return new RespuestaJSON("Libro eliminado exitosamente", TrxStatus.SUCCESS);
	}

	// ver detalle de un libro
	@RequestMapping(value = "/detalle{id}", method = RequestMethod.GET)
	@ResponseBody
	public String verDetalle(@PathVariable("id") String id, Model model, HttpServletRequest request) {

		return "detalle";
	}

}