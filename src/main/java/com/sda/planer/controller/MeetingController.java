package com.sda.planer.controller;

import com.sda.planer.model.Meeting;
import com.sda.planer.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetingPanel")
    public ModelAndView listAllMeetings() {
        ModelAndView modelAndView = new ModelAndView("/meetingPanel");
        modelAndView.addObject("meetings", meetingService.listAllMeetings());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showMeetingById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("/meetingPanel");
        modelAndView.addObject(meetingService.getMeetingById(id));
        return modelAndView;
    }

    @PostMapping
    public String addRoom(@ModelAttribute Meeting meeting) {
        meetingService.saveMeeting(meeting);
        return "redirect:/meetings/meetingPanel";
    }


}
