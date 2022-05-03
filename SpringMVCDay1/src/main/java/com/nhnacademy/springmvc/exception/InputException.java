package com.nhnacademy.springmvc.exception;

public class InputException extends RuntimeException {
    public InputException(){
        super("값을 똑바로 입력하세요");
    }
}
