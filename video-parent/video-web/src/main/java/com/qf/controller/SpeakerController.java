package com.qf.controller;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/showSpeakerList")
    public String getAllSpeaker(Model model , QueryVo queryVo){
        Page<Speaker> page = speakerService.getAllSpeaker(queryVo);
        model.addAttribute("page",page);
        return "/jsp/behind/speakerList.jsp";
    }

    @RequestMapping("/saveOrUpdate")
    public String addSpeaker(Speaker speaker){
        if(speaker.getId()!=null && !(speaker.getId().equals(""))){
            speakerService.updateSpeakerById(speaker);
        }else{
            speakerService.addSpeaker(speaker);
        }
        return "redirect:/speaker/showSpeakerList";
    }

    @RequestMapping("/edit")
    public String getSpeakerById(Integer id , Model model){
        if(id!=null){
            Speaker speaker = speakerService.getSpeakerById(id);
            model.addAttribute("speaker",speaker);
        }
        return "/jsp/behind/addSpeaker.jsp";
    }

    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(Integer id) {
        if(speakerService.delSpeakerById(id)==1){
            return "success";
        }else{
            return "error";
        }
    }
    /*----------------------------------------------------------------------*/
}
