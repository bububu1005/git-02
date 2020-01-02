package com.qf.dao;

import com.qf.entity.Speaker;
import com.qf.entity.User;
import com.qf.entity.Video;
import com.qf.entity.QueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoDao {

    List<Video> getAllVideo(QueryVo queryVo);
    //总数据
    int getCountAllVideo(QueryVo queryVo);
    //添加
    int addVideo(Video video);

    Video getVideoById(Integer id);
    //修改
    int updateVideoById(Video video);
    //删除
    int delVideoById(Integer id);

    Video getVideoAndSpeaker(Integer id);
    //更新播放次数
    int updatePlayNum(@Param("id") Integer id);
}
