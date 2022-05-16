package com.nhnacademy.midterm.visitor;

import com.nhnacademy.midterm.visitee.Doublequomaks;
import com.nhnacademy.midterm.visitee.EnterVisitee;
import com.nhnacademy.midterm.visitee.AnnotationVisitee;
import com.nhnacademy.midterm.visitee.NormalVisitee;
import com.nhnacademy.midterm.visitee.SpaceVisitee;
import com.nhnacademy.midterm.visitee.TabVisitee;
import com.nhnacademy.midterm.visitee.OrangeVisitee;

public interface Visitor {
    String annotationConvert(AnnotationVisitee annotationVisitee);

    String NormalConvert(NormalVisitee normalVisitee);

    String TabConvert(TabVisitee tabVisitee);

    String enterConvert(EnterVisitee enterVisitee);

    String spaceConvert(SpaceVisitee spaceVisitee);

    String orangeConvert(OrangeVisitee finalVisitee);

    String doublequotationmarks(Doublequomaks doublequomaks);
}

