package com.qf.controller;

import com.qf.entity.*;
import com.qf.service.*;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SpeakerService speakerService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/login")
    @ResponseBody
    public String toLogin(Admin admin, HttpServletRequest request){
        /*登录*/
        request.getSession().setAttribute("username",admin.getUsername());
        if(adminService.toLogin(admin)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/show")
    @ResponseBody
    public String toLogin(){

        return "show";
    }


    @RequestMapping("/list")
    public String show(Model model,QueryVo queryVo){
        Page<Video> page = videoService.getAllVideoByPage(queryVo);

        model.addAttribute("page", page);
        model.addAttribute("title", queryVo.getTitle());

        List<Speaker> speakerList = speakerService.getAllSpeaker();
        model.addAttribute("speakerList",speakerList);

        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList",courseList);

        return "/jsp/behind/videoList.jsp";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video){
        /*判断id是否为空*/
        if(video.getId()!=null && !(video.getId()).equals("")){
            videoService.updateVideoById(video);
        }else{
            videoService.addVideo(video);
        }
        return "redirect:/video/list";
    }
    /*根据id查询 修改 添加 下拉框使用*/
    @RequestMapping("/edit")
    public String getVideoById(Integer id , Model model){
        if(id!=null){
            Video video = videoService.getVideoById(id);
            model.addAttribute("video",video);
        }
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("courseList",courseList);
        List<Speaker> speakerList = speakerService.getAllSpeaker();
        model.addAttribute("speakerList",speakerList);
        return "/jsp/behind/addVideo.jsp";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String delVideoById(Integer id){
        videoService.delVideoById(id);
            return "success";
    }
    /*批量删除*/
    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(Integer ids[]){
        int count = 0;
        for(int id: ids){
            count+=videoService.delVideoById(id);
        }
        return "redirect:/video/list";
    }
/*---------------------------------------------------------------------------*/

    @RequestMapping("/showVideo")
    public String showVideo(Model model,Integer videoId ,String subjectName ,Integer courseId){
        /*显示视频*/
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);

        Video video = videoService.getVideoAndSpeaker(videoId);
        model.addAttribute("video",video);

        Course course = courseService.getCourseAndSpeaker(courseId);
        model.addAttribute("course",course);

        model.addAttribute("subject_name",subjectName);
        return "/jsp/before/section.jsp";
    }

    @RequestMapping("/updatePlayNum")
    public void updatePlayNum(Integer id){
        /*更新播放次数*/
        videoService.updatePlayNum(id);
    }
}
