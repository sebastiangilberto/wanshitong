package ar.com.sgilberto.dao;

import ar.com.sgilberto.entity.Usuario;

public interface ILoginDao {

	public boolean validateUser(Usuario usuario);

}