package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.videos.utils.Page;

import java.util.List;

public interface SpeakerService {

    List<Speaker> getAllSpeaker();

    Page<Speaker> getAllSpeaker(QueryVo queryVo);

    int addSpeaker(Speaker speaker);

    Speaker getSpeakerById(Integer id);

    int updateSpeakerById(Speaker speaker);

    int delSpeakerById(Integer id);

}
