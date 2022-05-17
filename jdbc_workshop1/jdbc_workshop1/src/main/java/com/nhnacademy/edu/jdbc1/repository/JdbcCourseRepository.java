package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.course.CourseRepository;
import java.sql.Timestamp;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCourseRepository implements CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCourseRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        "select id, teacher_id,subject_id, created_at from JdbcCourses  where id = ?",
                        (resultSet, rowNum) ->
                                new Course(resultSet.getLong("id"),
                                        resultSet.getLong("teacher_id"),
                                        resultSet.getLong("subject_id"),
                                        resultSet.getTimestamp("created_at")), id)
        );
    }

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(
                "select id,teacher_id,subject_id, created_at from JdbcCourses",
                (resultSet, rowNum) ->
                        new Course(resultSet.getLong("id"),
                                resultSet.getLong("teacher_id"),
                                resultSet.getLong("subject_id"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public int insert(Course course) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcStudents(id,teacher_id,subject_id, created_at) VALUES (?,?,?,?)",
                course.getId(),
                course.getTeacherId(),
                course.getTeacherId(),
                new Timestamp(new Date().getTime())

        );
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcStudents WHERE id=?",
                id
        );
    }

    @Override
    public int modify(Long id, Long teacherId, Long subjectId) {
        return 0;
    }
}