package com.nt.loginSignUp.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.loginSignUp.dao.StudentDao;
import com.nt.loginSignUp.dao.StudentRespository;
import com.nt.loginSignUp.model.Student;

@Repository("StudentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRespository studentRespository;

	@Override
	public Student save(Student student) {
		Student stu = studentRespository.save(student);
		return stu;
	}

	@Override
	public List<Student> findAll() {
		return studentRespository.findAll();
	}

	@Override
	public Student find(Long studentId) {
		Student student = null;
		Optional<Student> studentEntity = studentRespository.findAllById(studentId);
		if (studentEntity.isPresent()) {
			student = studentEntity.get();
		}

		return student;
	}

	@Override
	public Student update(Student student) {
		return studentRespository.save(student);
	}

	@Override
	public void remove(Long studentId) {
		studentRespository.deleteById(studentId);
	}

}
