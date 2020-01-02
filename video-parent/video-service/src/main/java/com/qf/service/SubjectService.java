package com.qf.service;

import com.qf.entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubject();

    Subject getSubjectAndCourseAndVideo(Integer subject_id);
}
