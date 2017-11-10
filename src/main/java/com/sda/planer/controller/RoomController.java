package com.sda.planer.controller;

import com.sda.planer.model.Room;
import com.sda.planer.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/roomPanel")
    public ModelAndView roomPanel() {
        ModelAndView modelAndView = new ModelAndView("roomPanel");
        modelAndView.addObject("rooms", roomService.getAllRooms());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getRoom(@PathVariable("id") long id) {
        Room room = roomService.getRoomById(id);
        ModelAndView modelAndView = new ModelAndView("room");
        modelAndView.addObject("room", room);
        return modelAndView;
    }

    @PostMapping
    public String addRoom(@ModelAttribute Room room) {
        roomService.addRoom(room);
        return "redirect:/rooms/roomPanel";
    }
}
