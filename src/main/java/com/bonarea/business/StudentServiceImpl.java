/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.business;

import com.bonarea.dao.StudentDao;
import com.bonarea.dao.StudentDaoImpl;
import com.bonarea.model.Student;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;
    
    public StudentServiceImpl(StudentDaoImpl studentDaoImpl){
        this.studentDao = studentDaoImpl;
    }
    
    @Override
    public Student add(Student student) throws SQLException {
        //Business Rules, authentication and authorization
        return studentDao.add(student);
    }
    
}
