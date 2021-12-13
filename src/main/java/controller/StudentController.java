package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Student;
import service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService api;
	
	@RequestMapping("/")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping("/list")
	public String listCustomers(Model model)
	{
		List<Student> students = api.getAll();
		model.addAttribute("students", students);
		return "list-students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "customer-form";
	}
	
	@RequestMapping("/saveStudent")
	public String saveCustomer(@ModelAttribute("customer") Student myStudent, 
			BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "student-form";
		}
		api.add(myStudent);
		return "list-students";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showUpdateForm(Model model, @RequestParam("studentId") int id) {
		Student student = api.get(id);
		model.addAttribute("student", student);
		return "update-form";
	}
	
	@RequestMapping("/updateStudent")
	public String updateCustomer(@ModelAttribute("student") Student myStudent,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "updateForm";
		}
		api.update(myStudent);
		return "list-students";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteCustomer(@RequestParam("studentId") int id) 
	{
		api.delete(id);
		return "list-students";
	}
}
