package com.nhnacademy.springmvc.domain;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Data
@Valid
public class StudentRegister {
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
}
