package com.sb.hyh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.hyh.entities.Student;
import com.sb.hyh.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getList() {
		return (List<Student>) studentRepository.findAll();
	}
}