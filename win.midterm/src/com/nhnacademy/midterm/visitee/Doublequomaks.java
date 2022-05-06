package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class Doublequomaks implements Visitee {

    private String value;

    public Doublequomaks(String value) {
        this.value = value;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.doublequotationmarks(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
