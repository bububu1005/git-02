package com.qf.service.impl;

import com.qf.dao.VideoDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.service.VideoService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public Page<Video> getAllVideoByPage(QueryVo queryVo){
        queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
        List<Video> allVideo = videoDao.getAllVideo(queryVo);
        Integer countAllVideo = videoDao.getCountAllVideo(queryVo);
        Page<Video> videoPage = new Page<Video>();
        videoPage.setRows(allVideo);
        videoPage.setPage(queryVo.getPage());
        videoPage.setSize(queryVo.getRows());
        videoPage.setTotal(countAllVideo);
        return videoPage;
    }

    @Override
    public int addVideo(Video video) {
        return videoDao.addVideo(video);
    }

    @Override
    public Video getVideoById(Integer id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public int updateVideoById(Video video) {
        return videoDao.updateVideoById(video);
    }

    @Override
    public int delVideoById(Integer id) {
        return videoDao.delVideoById(id);
    }

    @Override
    public Video getVideoAndSpeaker(Integer id) {
        return videoDao.getVideoAndSpeaker(id);
    }

    @Override
    public int updatePlayNum(Integer id) {
        return videoDao.updatePlayNum(id);
    }

}
