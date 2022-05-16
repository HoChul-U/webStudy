package com.nhnacademy.midterm;

import com.nhnacademy.midterm.util.JavaFileUtil;
import com.nhnacademy.midterm.visitee.AnnotationVisitee;
import com.nhnacademy.midterm.visitee.Doublequomaks;
import com.nhnacademy.midterm.visitee.EnterVisitee;
import com.nhnacademy.midterm.visitee.NormalVisitee;
import com.nhnacademy.midterm.visitee.OrangeVisitee;
import com.nhnacademy.midterm.visitee.SpaceVisitee;
import com.nhnacademy.midterm.visitee.TabVisitee;
import com.nhnacademy.midterm.visitor.ConvertHtml;
import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
//        CollectionToStringConverter ErrorManager
        String targetJavaFileName = "Wrapper";
        //application 실행되는 경로
        String basePath = System.getProperty("user.dir");
        String filePath1 =
            basePath + File.separator + "data" + File.separator + targetJavaFileName + ".java";
        List<String> lines = JavaFileUtil.getInstance().read(filePath1);

        ConvertHtml convertHtml = new ConvertHtml();
        StringTokenizer stringTokenizer;
        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            stringTokenizer = new StringTokenizer(line, " ", true);
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken(" ");
                if (token.contains("//")
                    || token.contains("/**")
                    | token.contains("*")
                    || token.contains("*/")
                    || token.contains("/*")) {
                    sb.append(new AnnotationVisitee(line).accept(convertHtml));
                    break;
                } else if (token.contains("\t")) {
                    sb.append(new TabVisitee(token).accept(convertHtml));
                } else if (token.contains("\n")) {
                    sb.append(new EnterVisitee(token).accept(convertHtml));
                } else if (token.contains(" ")) {
                    sb.append(new SpaceVisitee(token).accept(convertHtml));
                } else if (token.contains("implements")
                    || token.contains("static")
                    || token.contains("new")
                    || token.contains("final")
                    || token.contains("private")
                    || token.contains("return")
                    || token.contains("class")
                    || token.contains("public")
                    || token.contains("synchronized")
                    || token.contains("void")
                    || token.contains("import")
                    || token.contains("package")) {
                    sb.append(new OrangeVisitee(token).accept(convertHtml));
                } else if (token.contains("\"")) {
                    sb.append(new Doublequomaks(token).accept(convertHtml));
                }
                else{
                    sb.append(new NormalVisitee(token).accept(convertHtml));
                }
            }
            sb.append("<br>");
        }
        String templateHtmlPath =
            basePath + File.separator + "data" + File.separator + "template.html";
        String destHtmlPath =
            basePath + File.separator + "html" + File.separator + targetJavaFileName + ".html";
        JavaFileUtil.getInstance().createHtml(templateHtmlPath, destHtmlPath, sb.toString());
    }
}
