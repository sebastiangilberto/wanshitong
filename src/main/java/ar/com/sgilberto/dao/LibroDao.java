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
public class LibroDao implements ILibroDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Libro libro) {
		Session session = this.sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.persist(libro);
		tx.commit();

		session.close();

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
	public Libro getById(int id) {
		Session session = this.sessionFactory.openSession();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		return libro;
	}

	@Transactional
	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.openSession();
		Libro libro = (Libro) session.load(Libro.class, new Integer(id));
		if (null != libro) {
			Transaction tx = session.beginTransaction();
			session.delete(libro);
			tx.commit();

			session.close();
		}
	}
}