package dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import entity.Student;

@Repository
public interface StudentDao {
	public void create(Student student);
	public Student read(int id);
	public List<Student> readAll();
	public void update(Student student);
	public void delete(Student student);
}
