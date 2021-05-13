/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.dao.integration.test;

import com.bonarea.dao.StudentDao;
import com.bonarea.dao.StudentDaoImpl;
import com.bonarea.model.Student;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jordi
 */

public class StudentDaoIntegrationTest {
    
    StudentDao studentDao = new StudentDaoImpl();
    
    @BeforeClass
    public static void setup() {
        System.out.println("runs one time on startup");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("runs one time when finish all tests");
    }
       
    @Before
    public void init() {
        System.out.println("runs before each test method");
    }
    
    @After
    public void teardown() {
        System.out.println("runs after each test method");
    }
    
    @Test
    public void testAdd() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        assertTrue(studentDao.add(student)!=null);        
    }   
}
