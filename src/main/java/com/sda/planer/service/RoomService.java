package com.sda.planer.service;

import com.sda.planer.model.Room;
import com.sda.planer.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(long id){
        return roomRepository.findOne(id);
    }

    public void addRoom(Room room){
        roomRepository.save(room);
    }
}
