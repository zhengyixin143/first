package com.spring.first.dao;

import com.spring.first.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student,Long> {


}
