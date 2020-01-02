package com.qf.test;

import com.qf.dao.AdminDao;
import com.qf.dao.SpeakerDao;
import com.qf.dao.SubjectDao;
import com.qf.dao.VideoDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.entity.Subject;
import com.qf.entity.Video;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConText-dao.xml");
        VideoDao videoDao = (VideoDao) context.getBean("videoDao");
        QueryVo queryVo=new QueryVo();
        queryVo.setTitle("22");
        queryVo.setSpeakerId(218);
        List<Video> allVideo = videoDao.getAllVideo(queryVo);
        for(Video v: allVideo){
            System.out.println(v);

        }
    }

    @org.junit.Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        SpeakerDao speakerDao = (SpeakerDao) context.getBean("speakerDao");
        Speaker speaker=new Speaker();
        speaker.setId(14);
        speaker.setSpeaker_name("cdss");
        int i = speakerDao.updateSpeakerById(speaker);
        System.out.println(i);
    }
    @org.junit.Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        SubjectDao subjectDao = (SubjectDao) context.getBean("subjectDao");
        Subject subjectAndCourseAndVideo = subjectDao.getSubjectAndCourseAndVideo(1);
//        for(Subject s: subjectAndCourseAndVideo){
//            System.out.println(s.toString());
//        }
    }
}
