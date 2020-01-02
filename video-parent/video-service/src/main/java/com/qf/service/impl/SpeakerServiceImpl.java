package com.qf.service.impl;

import com.qf.dao.SpeakerDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.entity.Video;
import com.qf.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;

    @Override
    public List<Speaker> getAllSpeaker() {
        return speakerDao.getAllSpeaker();
    }

    @Override
    public Page<Speaker> getAllSpeaker(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
        List<Speaker> allSpeaker = speakerDao.getAllSpeaker();
        Integer countSpeaker = speakerDao.getCountSpeaker();
        Page<Speaker> speakerPage = new Page<Speaker>();
        speakerPage.setRows(allSpeaker);
        speakerPage.setPage(queryVo.getPage());
        speakerPage.setSize(queryVo.getRows());
        speakerPage.setTotal(countSpeaker);
        return speakerPage;
    }

    @Override
    public int addSpeaker(Speaker speaker) {
        return speakerDao.addSpeaker(speaker);
    }

    @Override
    public Speaker getSpeakerById(Integer id) {
        return speakerDao.getSpeakerById(id);
    }

    @Override
    public int updateSpeakerById(Speaker speaker) {
        return speakerDao.updateSpeakerById(speaker);
    }

    @Override
    public int delSpeakerById(Integer id) {
        return speakerDao.delSpeakerById(id);
    }

}
