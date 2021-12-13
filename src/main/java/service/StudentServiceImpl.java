package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Student;

import dao.StudentDao;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Student> getAll() {
		return dao.readAll();
	}

	@Override
	public void add(Student student) {
		dao.create(student);

	}

	@Override
	public void update(Student student) {
		dao.update(student);

	}

	@Override
	public void delete(int id) {
		Student student = dao.read(id);
		dao.delete(student);
	}

}
