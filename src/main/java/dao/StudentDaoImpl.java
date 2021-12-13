package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTransactionManager transactionManager;

	private Session getSession() {
		SessionFactory factory = transactionManager.getSessionFactory();
		return factory.getCurrentSession();
	}
		
	@Override
	@Transactional
	public void create(Student student) {
		Session session = getSession();
		session.save(student);
	}

	@Override
	@Transactional
	public Student read(int id) {
		Session session = getSession();
		return session.get(Student.class, id);
	}

	@Override
	@Transactional
	public List<Student> readAll() {
		Session session = getSession();
		return session.createQuery("FROM Student").list();
	}

	@Override
	@Transactional
	public void update(Student student) {
		Session session = getSession();
		session.update(student);
	}

	@Override
	@Transactional
	public void delete(Student student) {
		Session session = getSession();
		session.delete(student);
	}

}
