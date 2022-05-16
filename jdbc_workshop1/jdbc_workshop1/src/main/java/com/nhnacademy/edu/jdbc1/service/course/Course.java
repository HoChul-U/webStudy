package com.nhnacademy.edu.jdbc1.service.course;

import lombok.Data;

import java.util.Date;

@Data
public class Course {
    private final int id;
    private final int teacherId;
    private final int subjectId;
    private final Date createdAt;

    public Course(int id, int teacherId, int subjectId, Date createdAt) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.createdAt = createdAt;
    }
}
