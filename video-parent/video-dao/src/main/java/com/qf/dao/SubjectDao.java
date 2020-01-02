package com.qf.dao;

import com.qf.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDao {

    List<Subject> getAllSubject();

    Subject getSubjectAndCourseAndVideo(Integer subject_id);
}
