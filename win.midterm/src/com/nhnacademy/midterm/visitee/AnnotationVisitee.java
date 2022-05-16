package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public class AnnotationVisitee implements Visitee{
    private String value;

    public AnnotationVisitee(String value) {
        this.value = value;
    }

    @Override
    public String  accept(Visitor visitor) {
       return visitor.annotationConvert(this);
    }

    @Override
    public String getValue() {
        return value;
    }
}
