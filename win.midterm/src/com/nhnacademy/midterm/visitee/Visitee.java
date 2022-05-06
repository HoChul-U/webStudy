package com.nhnacademy.midterm.visitee;

import com.nhnacademy.midterm.visitor.Visitor;

public interface Visitee {
     String accept(Visitor visitor);

     String getValue();
}
