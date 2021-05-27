/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.model;

/**
 *
 * @author jordi
 */
public enum StudentOptions {

    ADD_STUDENT(1), UPDATE_STUDENT(2), 
    SHOW_STUDENTS(3), SEARCH_STUDENT_BY_ID(4),
    DELETE_STUDENT(5), EXIT(6);

    private int value;

    private StudentOptions(int value) {
        this.value = value;
    }

    public static StudentOptions fromValue(int value) {
        for (StudentOptions studentOptions : StudentOptions.values()) {
            if (studentOptions.value == value) {
                return studentOptions;
            }
        }

        return null;
    }

    public int value() {
        return value;
    }
}
