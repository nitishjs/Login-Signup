package com.nt.loginSignUp.service;

import java.util.List;

import com.nt.loginSignUp.model.Student;

public interface StudentService {
	public Student save(Student student);

	public List<Student> findAll();

	public Student find(Long studentId);

	public Student update(Student studentDetails);

	public void remove(Long studentId);
}
