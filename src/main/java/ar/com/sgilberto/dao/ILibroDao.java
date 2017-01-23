package ar.com.sgilberto.dao;

import java.util.List;

import ar.com.sgilberto.entity.Libro;

public interface ILibroDao {

	public void addLibro(Libro libro);

	public void updateLibro(Libro libro);

	public List<Libro> getLibros();

	public Libro getLibroById(int id);

	public void removeLibro(int id);

}