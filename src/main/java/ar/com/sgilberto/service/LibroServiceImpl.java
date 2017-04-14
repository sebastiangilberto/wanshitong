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
		this.libroDao.save(this.transformToEntity(libro));
	}

	@Override
	@Transactional
	public void updateLibro(LibroDto libro) {
		this.libroDao.update(this.transformToEntity(libro));
	}

	@Override
	@Transactional
	public List<LibroDto> getLibros() {

		List<LibroDto> result = new ArrayList<LibroDto>();
		List<Libro> listLibros = this.libroDao.getAll();

		for (Libro item : listLibros) {
			result.add(this.transformToDto(item));
		}

		return result;
	}

	@Override
	@Transactional
	public LibroDto getLibroById(Integer id) {

		// return this.transformToDto(this.libroDao.getLibroById(id));

		return null;

	}

	@Override
	@Transactional
	public void removeLibro(Integer id) {
		this.libroDao.remove(id);
	}

	private Libro transformToEntity(LibroDto libroDto) {

		Libro libro = new Libro();
		libro.setId(libroDto.getId());
		libro.setAutor(libroDto.getAutor());
		libro.setTitulo(libroDto.getTitulo());
		libro.setGenero(libroDto.getGenero());
		libro.setTapa(libroDto.getTapa());

		return libro;
	}

	private LibroDto transformToDto(Libro libroEntity) {

		LibroDto libro = new LibroDto();
		libro.setId(libroEntity.getId());
		libro.setAutor(libroEntity.getAutor());
		libro.setTitulo(libroEntity.getTitulo());
		libro.setGenero(libroEntity.getGenero());
		libro.setTapa(libroEntity.getTapa());

		return libro;
	}

}