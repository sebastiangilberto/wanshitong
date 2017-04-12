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
import ar.com.sgilberto.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "redirect:/login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) {

		UsuarioDto usuarioDto = new UsuarioDto();
		model.addAttribute("UsuarioDto", usuarioDto);
		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UsuarioDto usuario, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		boolean userValid = this.loginService.validateUser(usuario);

		if (userValid) {

			System.out.println("Usuario Valido");
			model.addAttribute("usuario", usuario);
			return "redirect:/catalogo";

		} else {

			System.out.println("Usuario Invalido");
			model.addAttribute("errorMessage", "Usuario o Password incorrectos");
			model.addAttribute("UsuarioDto", new UsuarioDto());
			return "login";

		}

	}

}