package com.chat_app.backend_chat_app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat_app.backend_chat_app.entities.Message;
import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.repositories.RoomRepository;
import com.chat_app.backend_chat_app.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  public RoomRepository roomRepository;

  @Override
  public void addMessageInRoom(Room room, Message message) {
    room.getMessages().add(message);
    this.roomRepository.save(room);
  }

}
