package com.student.rest.exceptions;;

public class CourseDoesNotExistsException extends Exception{
    public CourseDoesNotExistsException() {};

    public CourseDoesNotExistsException(String msg) {
        super(msg);
    }
}
