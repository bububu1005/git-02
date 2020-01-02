package com.qf.controller;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.entity.Subject;
import com.qf.entity.Video;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/showCourseList")
    public String getAllCourse(Model model , QueryVo queryVo){
        Page<Course> page = courseService.getAllCourse(queryVo);
        model.addAttribute("page",page);
        return "/jsp/behind/courserList.jsp";
    }

    @RequestMapping("/saveOrUpdate")
    public String addCourse(Course course){
        if(course.getId()!=null && !course.getId().equals("")){
            /*修改*/
            courseService.updateCourseById(course);
        }else{
            /*添加*/
            courseService.addCount(course);
        }
        return "redirect:/course/showCourseList";
    }

    @RequestMapping("/edit")
    public String getCourseById(Model model , Integer id){
        if(id!=null){
            Course course = courseService.getCourseById(id);
            model.addAttribute("course",course);
        }
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "/jsp/behind/addCourse.jsp";
    }

    @RequestMapping("/courserDel")
    @ResponseBody
    public String delCourseById(Model model , Integer id){
        courseService.delCourseById(id);
            return "success";
        }
    /*-------------------------------------------------------------------------------------*/
    @RequestMapping("/course/{id}")
    public String getSubjectAndCourseAndVideo(Model model,@PathVariable(name = "id") String id){
        Subject subject = subjectService.getSubjectAndCourseAndVideo(Integer.parseInt(id));
        model.addAttribute("subject",subject);

        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "/jsp/before/course.jsp";
    }

}
