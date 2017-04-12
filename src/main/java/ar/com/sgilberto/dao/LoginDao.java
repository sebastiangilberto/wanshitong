package ar.com.sgilberto.dao;

import ar.com.sgilberto.entity.Usuario;

public interface LoginDao {

	public boolean validateUser(Usuario usuario);

}