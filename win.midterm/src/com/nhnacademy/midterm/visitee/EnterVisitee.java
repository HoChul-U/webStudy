package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class EnterVisitee implements Visitee{
    private String value;
    @Override
    public String accept(Visitor visitor) {
        return visitor.enterConvert(this);
    }

    public EnterVisitee(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
