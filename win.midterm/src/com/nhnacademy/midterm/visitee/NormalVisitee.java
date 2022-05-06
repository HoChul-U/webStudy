package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class NormalVisitee implements Visitee{
    private String value;

    public NormalVisitee(String value) {
        this.value = value;
    }

    @Override
    public String  accept(Visitor visitor) {
        return visitor.NormalConvert(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
