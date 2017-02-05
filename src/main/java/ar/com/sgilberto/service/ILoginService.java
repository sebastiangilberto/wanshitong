package ar.com.sgilberto.service;

import ar.com.sgilberto.model.UsuarioDto;

public interface ILoginService {

	public boolean validateUser(UsuarioDto user);
	
}
