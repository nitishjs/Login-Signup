package com.nt.loginSignUp.dao;

import java.util.List;

import com.nt.loginSignUp.model.Student;

public interface StudentDao {
	public Student save(Student student);

	public List<Student> findAll();

	public Student find(Long studentId);

	public Student update(Student student);

	public void remove(Long studentId);

}
