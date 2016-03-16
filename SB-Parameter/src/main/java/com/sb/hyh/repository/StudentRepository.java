package com.sb.hyh.repository;

import org.springframework.data.repository.CrudRepository;

import com.sb.hyh.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
