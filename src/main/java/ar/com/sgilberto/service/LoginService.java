package ar.com.sgilberto.service;

import ar.com.sgilberto.model.UsuarioDto;

public interface LoginService {

	public boolean validateUser(UsuarioDto user);
	
}
