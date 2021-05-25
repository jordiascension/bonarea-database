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
    public void teardown() throws SQLException, ClassNotFoundException {
        System.out.println("runs after each test method");
        studentDao.deleteAll();
    }
    
    @Test
    public void testAdd() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        assertTrue(studentDao.add(student)!=null);        
    }   
    
    @Test
    public void testGetById() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        Student studentAdded = studentDao.add(student);  
        assertTrue(studentDao.getStudentById(studentAdded.getId())!=null);
    }   
    
    @Test
    public void testDelete() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        Student studentAdded = studentDao.add(student);  
        assertTrue(studentDao.delete(studentAdded.getId()) > 0);
    }   
    
    @Test
    public void testGetAll() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        Student student1 = new Student();
        student1.setFirstName("Juan");
        student1.setLastName("Ferrer");
        student1.setEmail("juan@gmail.com");
        
        studentDao.add(student); 
        studentDao.add(student1);
        assertTrue(studentDao.getAll().size() == 2);
    }   
    
    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException{
        Student student = new Student();
        student.setFirstName("Pepe");
        student.setLastName("Soto");
        student.setEmail("pepe@gmail.com");
        
        Student studentAdded = studentDao.add(student);  
        assertTrue(studentDao.update(studentAdded)!=null);
    }   
}
