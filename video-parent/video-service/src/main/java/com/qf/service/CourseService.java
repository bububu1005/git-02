package com.qf.service;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.entity.Subject;
import com.qf.videos.utils.Page;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    Page<Course> getAllCourse(QueryVo queryVo);

    int addCount(Course course);

    Course getCourseById(Integer id);

    int updateCourseById(Course course);

    int delCourseById(Integer id);

    List<Course> getCourseBySubject_id(Integer subject_id);

    Course getCourseAndSpeaker(Integer course_id);
}
