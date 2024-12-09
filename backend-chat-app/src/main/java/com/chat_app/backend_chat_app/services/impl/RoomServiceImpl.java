package com.chat_app.backend_chat_app.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.entities.User;
import com.chat_app.backend_chat_app.exceptions.ResourceNotFoundException;
import com.chat_app.backend_chat_app.repositories.RoomRepository;
import com.chat_app.backend_chat_app.repositories.UserRepository;
import com.chat_app.backend_chat_app.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  public RoomRepository roomRepository;

  @Autowired
  public UserRepository userRepository;

  @Override
  public Room getRoomByRoomId(String roomId) {
    return this.roomRepository.findById(roomId)
        .orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
  }

  @Override
  public String createRoom(int userId, String roomName) {
    User user = this.userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User", "user ID", userId));
    boolean isPresent = this.roomRepository.findByRoomName(roomName).isPresent();
    if (isPresent) {
      return "Already existed !!";
    }
    Room room = new Room();
    room.setUser(user);
    room.setRoomName(roomName);
    room.setRoomId(UUID.randomUUID().toString());
    user.addRoom(room);
    this.userRepository.save(user);
    return room.getRoomId();
  }

}
