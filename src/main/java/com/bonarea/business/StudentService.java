/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.business;

import com.bonarea.model.Student;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public interface StudentService {
    Student add(Student student)  throws SQLException;
}
