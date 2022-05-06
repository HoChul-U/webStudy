package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class SpaceVisitee implements Visitee{
    String value;

    public SpaceVisitee(String value) {
        this.value = value;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.spaceConvert(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
