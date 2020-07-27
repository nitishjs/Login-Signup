package com.nt.loginSignUp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.loginSignUp.model.Student;
import com.nt.loginSignUp.service.StudentService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1")
public class StudenController {
	private static final Logger logger = LoggerFactory.getLogger(StudenController.class);

	@Autowired
	private StudentService studentService;

	/**
	 * Get all student list.
	 *
	 * @return the list
	 */
	@GetMapping("/student")
	public ResponseEntity<Student> getAllStudents() {
		List<Student> students = studentService.findAll();
		return new ResponseEntity<Student>((Student) students, HttpStatus.OK);
	}

	/**
	 * Gets student by id.
	 * 
	 * @param StudentId the student id
	 * @return the students by id
	 */
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
		Student student = studentService.find(studentId);
		System.out.println(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	/**
	 * Create Student Student.
	 *
	 * @param student the student
	 * @return the student
	 */
	@PostMapping("/student")
	public ResponseEntity<Student> createStdent(@Validated @RequestBody Student student) {
		logger.info("Insert student data : ");
		student = studentService.save(student);

		return new ResponseEntity<Student>(student, HttpStatus.CREATED);

	}

	/**
	 * Update user response entity.
	 *
	 * @param studentId      the student id
	 * @param studentDetails the student details
	 * @return the response entity
	 */
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
			@Validated @RequestBody Student studentDetails) {

		Student student = studentService.find(studentId);
		if (ObjectUtils.isEmpty(student)) {
			System.out.println("student details not found ");
		}
		Student students = studentService.update(studentDetails);
		return ResponseEntity.ok(students);
	}

	/**
	 * Delete student map.
	 *
	 * @param studetId the student id
	 * @return the map
	 */
	@DeleteMapping("/student/{id}")
	public Map<String, Boolean> removeStudent(@PathVariable(value = "id") Long studentId) {

		Student student = studentService.find(studentId);
		if (ObjectUtils.isEmpty(student)) {
			System.out.println("student details not found ");
		}
		studentService.remove(studentId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
