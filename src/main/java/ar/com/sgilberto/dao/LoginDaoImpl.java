package ar.com.sgilberto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.sgilberto.entity.Usuario;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Override
	public boolean validateUser(Usuario usuario) {
		Session session = this.sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Usuario.class);

		Criterion username = Restrictions.like("username", usuario.getUsername());
		Criterion password = Restrictions.like("password", usuario.getPassword());

		LogicalExpression restrictions = Restrictions.and(username, password);
		criteria.add(restrictions);

		System.out.println("Usuario  ----> " + usuario.getUsername());
		System.out.println("Password ----> " + usuario.getPassword());

		List result = criteria.list();

		return !result.isEmpty();

	}

}