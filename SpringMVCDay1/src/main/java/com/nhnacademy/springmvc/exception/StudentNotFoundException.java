package com.nhnacademy.springmvc.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("학생을찾을수 없습니다.");
    }
}
