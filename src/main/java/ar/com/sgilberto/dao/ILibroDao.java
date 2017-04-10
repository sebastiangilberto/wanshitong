package ar.com.sgilberto.dao;

import java.util.List;

import ar.com.sgilberto.entity.Libro;

public interface ILibroDao {

	public void save(Libro libro);

	public void update(Libro libro);

	public List<Libro> getAll();

	public Libro getById(Integer id);

	public void remove(Integer id);

}