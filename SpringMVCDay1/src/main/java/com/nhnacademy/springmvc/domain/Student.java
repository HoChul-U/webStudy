package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class Student {

    private long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @Max(100)
    @Min(0)
    private int score;
    @NotBlank
    @Length(min = 0,max = 200)
    private String comment;

    public Student(long id, String name, String email, int score, String comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }

}