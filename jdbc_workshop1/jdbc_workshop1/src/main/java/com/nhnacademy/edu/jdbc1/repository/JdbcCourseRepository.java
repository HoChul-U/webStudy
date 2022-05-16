package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.service.course.Course;
import com.nhnacademy.edu.jdbc1.service.course.CourseRepository;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class JdbcCourseRepository implements CourseRepository {
    @Override
    public Optional<Course> findById(int id) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcCourses WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(new Course(resultSet.getInt("id"),
                        resultSet.getInt("teacher_id"),
                        resultSet.getInt("subject_id"),
                        resultSet.getTimestamp("created_at")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcCourses");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                courses.add(
                        new Course(resultSet.getInt("id"),
                                resultSet.getInt("teacher_id"),
                                resultSet.getInt("subject_id"),
                                resultSet.getTimestamp("created_at"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int insert(Course course) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JdbcCourses (id,teacher_id,subject_id,created_at) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, course.getId());
            preparedStatement.setInt(2, course.getTeacherId());
            preparedStatement.setInt(3,course.getSubjectId());
            preparedStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try(Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JdbcCourses WHERE id=?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int modify(int id, int teacherId, int subjectId) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JdbcCourses SET teacher_id=?, subject_id=? WHERE =?");
            preparedStatement.setInt(1, teacherId);
            preparedStatement.setInt(2, subjectId);
            preparedStatement.setInt(3, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
