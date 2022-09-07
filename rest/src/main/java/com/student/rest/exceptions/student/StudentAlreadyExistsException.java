package com.student.rest.exceptions.student;

public class StudentAlreadyExistsException extends Exception {
    public StudentAlreadyExistsException() {};

    public StudentAlreadyExistsException(String msg) {
        super(msg);
    }
}
