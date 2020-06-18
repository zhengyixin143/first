package com.spring.first.serviceimpl;

import com.spring.first.dao.StudentDao;
import com.spring.first.domain.Student;
import com.spring.first.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
 @Autowired
    private StudentDao studentDao;

   public void save(Student student){
       studentDao.save(student);
   };



}
