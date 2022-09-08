package com.student.rest.exceptions.student;

public class StudentDoesNotExistException extends Exception {
    public StudentDoesNotExistException() {};

    public StudentDoesNotExistException(String msg) {
        super(msg);
    }
}
