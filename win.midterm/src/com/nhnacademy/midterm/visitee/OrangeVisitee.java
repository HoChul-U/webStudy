package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class OrangeVisitee implements Visitee {
    private String value;

    public OrangeVisitee(String value) {
        this.value = value;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.orangeConvert(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
