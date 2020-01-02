package com.qf.service.impl;

import com.qf.dao.CourseDao;
import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.service.CourseService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public Page<Course> getAllCourse(QueryVo queryVo){
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
        List<Course> allCourse = courseDao.getAllCourse();
        Integer countCourse = courseDao.getCountCourse();
        Page<Course> coursePage = new Page<Course>();
        coursePage.setRows(allCourse);
        coursePage.setPage(queryVo.getPage());
        coursePage.setSize(queryVo.getRows());
        coursePage.setTotal(countCourse);
        return coursePage;
    }

    @Override
    public int addCount(Course course) {
        return courseDao.addCount(course);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public int updateCourseById(Course course) {
        return courseDao.updateCourseById(course);
    }

    @Override
    public int delCourseById(Integer id) {
        return courseDao.delCoureById(id);
    }

    @Override
    public List<Course> getCourseBySubject_id(Integer subject_id) {
        return courseDao.getCourseBySubject_id(subject_id);
    }

    @Override
    public Course getCourseAndSpeaker(Integer course_id) {
        return courseDao.getCourseAndSpreaker(course_id);
    }

}
