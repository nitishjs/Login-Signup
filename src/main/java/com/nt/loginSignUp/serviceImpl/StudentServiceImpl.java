package com.nt.loginSignUp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.loginSignUp.dao.StudentDao;
import com.nt.loginSignUp.model.Student;
import com.nt.loginSignUp.service.StudentService;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student save(Student student) {

		return studentDao.save(student);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student find(Long studentId) {
		return studentDao.find(studentId);

	}

	@Override
	public Student update(Student studentDetails) {
		Student student = new Student();
		student.setFirstName(studentDetails.getFirstName());
		student.setAge(studentDetails.getAge());

		return studentDao.update(student);
	}

	@Override
	public void remove(Long studentId) {
		studentDao.remove(studentId);
	}
}
