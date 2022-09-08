package com.student.rest.exceptions.course;

public class CourseAlreadyExistsException extends Exception {
    public CourseAlreadyExistsException() {};

    public CourseAlreadyExistsException(String msg) {
        super(msg);
    }
}
