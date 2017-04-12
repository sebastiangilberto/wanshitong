package ar.com.sgilberto.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgilberto.entity.Libro;

@Repository
public class LibroDaoImpl implements LibroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Libro libro) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(libro);
		session.flush();
		session.clear();
		trans.commit();

	}

	@Override
	@Transactional
	public void update(Libro libro) {
		Session session = this.sessionFactory.openSession();
		session.update(libro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> getAll() {
		Session session = this.sessionFactory.openSession();

		List<Libro> libros = session.createCriteria(Libro.class).list();

		return libros;
	}

	@Override
	@Transactional
	public Libro getById(Integer id) {
		Session session = this.sessionFactory.openSession();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		return libro;
	}

	@Transactional
	@Override
	public void remove(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		session.delete(libro);
		trans.commit();

	}
}