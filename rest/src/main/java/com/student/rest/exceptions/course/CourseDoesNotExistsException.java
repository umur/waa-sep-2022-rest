package com.student.rest.exceptions.course;;

public class CourseDoesNotExistsException extends Exception{
    public CourseDoesNotExistsException() {};

    public CourseDoesNotExistsException(String msg) {
        super(msg);
    }
}
