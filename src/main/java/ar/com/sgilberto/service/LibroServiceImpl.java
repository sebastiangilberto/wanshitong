package ar.com.sgilberto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgilberto.dao.LibroDao;
import ar.com.sgilberto.entity.Libro;
import ar.com.sgilberto.model.LibroDto;

@Service
public final class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroDao libroDao;

	@Override
	@Transactional
	public void addLibro(LibroDto libro) {
		Libro libroEntity = new Libro();

		libroEntity.setAutor(libro.getAutor());
		libroEntity.setTitulo(libro.getTitulo());
		libroEntity.setGenero(libro.getGenero());
		libroEntity.setTapa(libro.getTapa());

		this.libroDao.save(libroEntity);
	}

	@Override
	@Transactional
	public void updateLibro(LibroDto libro) {
		Libro libroEntity = new Libro();
		// seteo valores del entity basados en el dto
		this.libroDao.update(libroEntity);
	}

	@Override
	@Transactional
	public List<LibroDto> getLibros() {

		// obtengo los librosEntitys y los paso a dto

		List<LibroDto> result = new ArrayList<LibroDto>();
		List<Libro> listLibros = this.libroDao.getAll();

		for (Libro item : listLibros) {
			LibroDto libro = new LibroDto();
			libro.setId(item.getId());
			libro.setAutor(item.getAutor());
			libro.setTitulo(item.getTitulo());
			libro.setGenero(item.getGenero());
			libro.setTapa(item.getTapa());

			result.add(libro);
		}

		return result;
	}

	@Override
	@Transactional
	public LibroDto getLibroById(Integer id) {

		// obtengo los librosEntitys y los paso a dto

		// LibroEntity libro = this.libroDao.getLibroById(id);

		LibroDto result = new LibroDto();

		return result;

	}

	@Override
	@Transactional
	public void removeLibro(Integer id) {
		this.libroDao.remove(id);
	}
}