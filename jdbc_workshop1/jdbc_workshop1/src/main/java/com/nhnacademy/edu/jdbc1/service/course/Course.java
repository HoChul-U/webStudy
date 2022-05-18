package com.nhnacademy.edu.jdbc1.service.course;

import lombok.Data;

import java.util.Date;

@Data
public class Course {
    private final Long id;
    private final Long teacherId;
    private final Long subjectId;
    private final Date createdAt;

    public Course(Long id, Long teacherId, Long subjectId, Date createdAt) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.createdAt = createdAt;
    }
}
