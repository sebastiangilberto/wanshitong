package ar.com.sgilberto.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgilberto.entity.Libro;

@Repository
public class LibroDao implements ILibroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addLibro(Libro libro) {
		Session session = this.sessionFactory.openSession();
		session.persist(libro);
	}

	@Override
	public void updateLibro(Libro libro) {
		Session session = this.sessionFactory.openSession();
		session.update(libro);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Libro> getLibros() {
		Session session = this.sessionFactory.openSession();

		List<Libro> libros = session.createCriteria(Libro.class).list();

		System.out.println("BABNA");

		return libros;
	}

	@Transactional
	@Override
	public Libro getLibroById(int id) {
		Session session = this.sessionFactory.openSession();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		return libro;
	}

	@Transactional
	@Override
	public void removeLibro(int id) {
		Session session = this.sessionFactory.openSession();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		if (null != libro) {
			session.delete(libro);
		}
	}
}