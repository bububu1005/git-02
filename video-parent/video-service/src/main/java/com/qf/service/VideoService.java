package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.videos.utils.Page;

public interface VideoService {

    Page<Video> getAllVideoByPage(QueryVo queryVo);

    int addVideo(Video video);

    Video getVideoById(Integer id);

    int updateVideoById(Video video);

    int delVideoById(Integer id);

    Video getVideoAndSpeaker(Integer id);

    int updatePlayNum(Integer id);
}
