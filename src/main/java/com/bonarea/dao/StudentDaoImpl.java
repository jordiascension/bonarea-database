/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.dao;

import com.bonarea.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public class StudentDaoImpl implements StudentDao {

    private final static String CONNECTIONSTRING
            = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_e64aed2083389e0";
    private final static String USER = "bfeb87d5f03af0";
    private final static String PWD = "ce5d6745";
    private final static String INSERT_STATEMENT = "INSERT INTO student(firstname, " +
                 "lastname, email) values(?,?,?)";
    
    @Override
    public Student add(Student student) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(CONNECTIONSTRING,
                USER, PWD);

        PreparedStatement preparedInsert = con.prepareStatement(INSERT_STATEMENT
                , PreparedStatement.RETURN_GENERATED_KEYS);
        //TODO
        //SET preparedstatement parameters
        preparedInsert.setString(1, student.getFirstName());
        preparedInsert.setString(2, student.getLastName());
        preparedInsert.setString(3, student.getEmail());
        
        preparedInsert.executeUpdate();
        
        // Se obtiene la clave generada
        ResultSet resultset = preparedInsert.getGeneratedKeys();
        while (resultset.next()) {
            int generatedKey = resultset.getInt(1);
            System.out.println("Clave generada = " + generatedKey);
        }
        return student;
    }

    @Override
    public Student getStudentById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
