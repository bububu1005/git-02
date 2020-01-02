package com.qf.service.impl;

import com.qf.dao.SubjectDao;
import com.qf.entity.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public Subject getSubjectAndCourseAndVideo(Integer subject_id) {
        return subjectDao.getSubjectAndCourseAndVideo(subject_id);
    }
}
