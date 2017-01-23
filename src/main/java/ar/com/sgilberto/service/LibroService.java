package ar.com.sgilberto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgilberto.dao.ILibroDao;
import ar.com.sgilberto.entity.Libro;
import ar.com.sgilberto.model.LibroDto;

@Service
public final class LibroService implements ILibroService {

	@Autowired
	private ILibroDao libroDao;

	@Override
	@Transactional
	public void addLibro(LibroDto Libro) {
		Libro libroEntity = new Libro();
		// seteo valores del entity basados en el dto
		this.libroDao.addLibro(libroEntity);
	}

	@Override
	@Transactional
	public void updateLibro(LibroDto Libro) {
		Libro libroEntity = new Libro();
		// seteo valores del entity basados en el dto
		this.libroDao.updateLibro(libroEntity);
	}

	@Override
	@Transactional
	public List<LibroDto> getLibros() {

		// obtengo los librosEntitys y los paso a dto

		List<LibroDto> result = new ArrayList<LibroDto>();
		List<Libro> listLibros = this.libroDao.getLibros();

		for (Libro item : listLibros) {
			LibroDto libro = new LibroDto();
			libro.setAutor(item.getAutor());
			libro.setTitulo(item.getTitulo());
			libro.setGenero(item.getGenero());

			result.add(libro);
		}

		return result;
	}

	@Override
	@Transactional
	public LibroDto getLibroById(int id) {

		// obtengo los librosEntitys y los paso a dto

		// LibroEntity libro = this.libroDao.getLibroById(id);

		LibroDto result = new LibroDto();

		return result;

	}

	@Override
	@Transactional
	public void removeLibro(int id) {
		this.libroDao.removeLibro(id);
	}
}