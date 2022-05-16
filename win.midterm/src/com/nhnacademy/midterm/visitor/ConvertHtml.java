package com.nhnacademy.midterm.visitor;

import com.nhnacademy.midterm.visitee.AnnotationVisitee;
import com.nhnacademy.midterm.visitee.Doublequomaks;
import com.nhnacademy.midterm.visitee.EnterVisitee;
import com.nhnacademy.midterm.visitee.NormalVisitee;
import com.nhnacademy.midterm.visitee.OrangeVisitee;
import com.nhnacademy.midterm.visitee.SpaceVisitee;
import com.nhnacademy.midterm.visitee.TabVisitee;
import java.util.StringTokenizer;

public class ConvertHtml implements Visitor {
    @Override
    public String annotationConvert(AnnotationVisitee annotationVisitee) {
        String value = "";
        for (int i = 0; i < annotationVisitee.getValue().split("@").length; i++) {
            System.out.println(value);
            if (i == 1) {
                value +=
                    "<span style='color:#1976D2'>" + "@" + annotationVisitee.getValue().split("@")[1] + "</span>";
            } else {
                value +="<span style='color:blue'>" + annotationVisitee.getValue().split("@")[i] + "</span>";
            }
        }
        return value;
    }

    @Override
    public String NormalConvert(NormalVisitee normalVisitee) {
        String value="";
        if(normalVisitee.getValue().contains("<")){
         value+= "<span style='color:black'>" +"&lt;"+ normalVisitee.getValue() + "</span>&nbsp";
        }else if(normalVisitee.getValue().contains(">")){
            value+= "<span style='color:black'>"+ normalVisitee.getValue() +" &gt;"+"</span>&nbsp";
        }
        return "<span style='color:black'>" + normalVisitee.getValue() + "</span>&nbsp";
    }

    @Override
    public String TabConvert(TabVisitee tabVisitee) {
        return "&nbsp&nbsp&nbsp&nbsp";
    }

    @Override
    public String enterConvert(EnterVisitee enterVisitee) {
        return "</br>";
    }

    @Override
    public String spaceConvert(SpaceVisitee spaceVisitee) {
        return "&nbsp";
    }

    @Override
    public String orangeConvert(OrangeVisitee finalVisitee) {
        return "<span style='color:orange'>" + finalVisitee.getValue() + "</span>&nbsp;";
    }

    @Override
    public String doublequotationmarks(Doublequomaks doublequomaks) {
        String[] split = doublequomaks.getValue().split("\"");
        String value = "";
        for (int i = 0; i < split.length; i++) {
            if (i == 1) {
                value += "<span style='color:green'>" + "\"" + split[i] + "\"" + "</span>&nbsp";
            } else {
                value += "<span style='color:black'>" + split[i] + "</span>";
            }
        }
        return value;
    }
}
