package ar.com.sgilberto.service;

import java.util.List;

import ar.com.sgilberto.model.LibroDto;

public interface ILibroService {

	public void addLibro(LibroDto libro);

	public void updateLibro(LibroDto libro);

	public List<LibroDto> getLibros();

	public LibroDto getLibroById(Integer id);

	public void removeLibro(Integer id);


}
