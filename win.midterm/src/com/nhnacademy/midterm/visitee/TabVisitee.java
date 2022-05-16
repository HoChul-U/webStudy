package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class TabVisitee implements Visitee{
    private String value;

    public TabVisitee(String value) {
        this.value = value;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.TabConvert(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
