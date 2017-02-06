package ar.com.sgilberto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgilberto.model.UsuarioDto;
import ar.com.sgilberto.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model, HttpServletRequest request, HttpServletResponse response) {

		UsuarioDto usuarioDto = new UsuarioDto();
		model.addAttribute("UsuarioDto", usuarioDto);
		return new ModelAndView("login");

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute UsuarioDto usuario, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		boolean userValid = this.loginService.validateUser(usuario);

		if (userValid) {

			System.out.println("Usuario Valido");
			model.addAttribute("usuario", usuario);
			return new ModelAndView("index");

		} else {

			System.out.println("Usuario Invalido");
			model.addAttribute("errorMessage", "Usuario o Password incorrectos");
			model.addAttribute("UsuarioDto", new UsuarioDto());
			return new ModelAndView("login");

		}

	}

}