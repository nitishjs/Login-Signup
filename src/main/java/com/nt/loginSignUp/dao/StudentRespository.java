package com.nt.loginSignUp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nt.loginSignUp.model.Student;

@EnableJpaRepositories
public interface StudentRespository extends JpaRepository<Student, Long> {

	Optional<Student> findAllById(Long studentId);

}
