package com.qf.dao;

import com.qf.entity.Speaker;

import java.util.List;

public interface SpeakerDao {

    List<Speaker> getAllSpeaker();

    Integer getCountSpeaker();

    Integer addSpeaker(Speaker speaker);

    Speaker getSpeakerById(Integer id);

    Integer updateSpeakerById(Speaker speaker);

    Integer delSpeakerById(Integer id);
}
