package com.qf.dao;

import com.qf.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    List<Course> getAllCourse();

    Integer getCountCourse();

    Integer addCount(Course course);

    Course getCourseById(Integer id);

    Integer updateCourseById(Course course);

    Integer delCoureById(Integer id);

    List<Course> getCourseBySubject_id(Integer subject_id);

    Course getCourseAndSpreaker(Integer course_id);
}
