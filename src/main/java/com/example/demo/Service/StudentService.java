package com.example.demo.Service;

import com.example.demo.Entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
  public Student saveStudent(Student student);
  public Student getStudentById(Long id);
  public Student updateStudent(Student student);
  public void deleStudentById(Long id);
}
