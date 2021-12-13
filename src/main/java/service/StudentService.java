package service;

import java.util.List;
import entity.Student;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
	public Student get(int id);
	public List<Student> getAll();
	public void add(Student Student);
	public void update(Student Student);
	public void delete(int id);
}
