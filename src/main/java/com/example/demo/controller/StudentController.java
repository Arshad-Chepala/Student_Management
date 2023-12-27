package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student =new Student();
        model.addAttribute("student", student);
        return"create_student";
    }
    @PostMapping("/students")
    public String saveStudents(@ModelAttribute("student") Student students){
      studentService.saveStudent(students);
      return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("Student") Student Student ,Model model){
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(Student.getFirstName());
        existingStudent.setLastName(Student.getLastName());
        existingStudent.setEmail(Student.getEmail());
     studentService.updateStudent(existingStudent);
     return "redirect:/students";
    }

    
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
       studentService.deleStudentById(id);
       return "redirect:/students";
    }

}
