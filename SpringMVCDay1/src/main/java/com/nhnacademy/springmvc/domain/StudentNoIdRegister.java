package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class StudentNoIdRegister {
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
}
