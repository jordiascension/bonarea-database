/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.presentation;

import com.bonarea.business.StudentService;
import com.bonarea.business.StudentServiceImpl;
import com.bonarea.dao.StudentDaoImpl;
import com.bonarea.model.Student;
import com.bonarea.model.StudentOptions;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author jordi
 */
public class StudentConsole {

    public static void selectOperation() {
        
        StudentOptions studentOptions = null;
        int option;
        
        Scanner scanner = new Scanner(System.in);
        
        StudentService studentService = 
                new StudentServiceImpl(new StudentDaoImpl());

        do {
            showPrincipalMenu();
            // The nextInt() method does not deal with the EOL token,
            // while nextLine() does.
            option = Integer.parseInt(scanner.nextLine());
            studentOptions = StudentOptions.fromValue(option);

            switch (studentOptions) {
                case ADD_STUDENT:
                    Student student = new Student();
                    addNewStudent(student, scanner);
                    try {
                        studentService.add(student);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());                
                    }
                    break;
                case EXIT:
                    System.out.println("Good Bye!!");
                    break;
                default:
                    System.out.println("You should select a value from 1 to 6");
                    break;
            }
        } while (option != studentOptions.EXIT.value());
        scanner.close();
    }

    private static void showPrincipalMenu() {
        System.out.println("¿Qué opción quiere seleccionar?");
        System.out.println("1.Agregar un nuevo estudiante");
        System.out.println("2.Actualizar estudiante");
        System.out.println("3.Mostrar estudiantes");
        System.out.println("4.Buscar estudiante por id");
        System.out.println("5.Borrar estudiante");
        System.out.println("6.Salir");
    }

    private static void addNewStudent(Student student, Scanner scanner) {
        System.out.println("1.Agregar un nuevo estudiante");
        System.out.println("Introduce nombre: ");
        student.setFirstName(scanner.nextLine());

        System.out.println("Introduce apellidos: ");
        student.setLastName(scanner.nextLine());

        System.out.println("Introduce email: ");
        student.setEmail(scanner.nextLine());
    }
}
