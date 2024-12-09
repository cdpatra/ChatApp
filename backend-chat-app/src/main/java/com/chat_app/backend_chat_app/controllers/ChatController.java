package com.chat_app.backend_chat_app.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.chat_app.backend_chat_app.entities.Message;
import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.entities.User;
import com.chat_app.backend_chat_app.payloads.MessageRequest;
import com.chat_app.backend_chat_app.services.MessageService;
import com.chat_app.backend_chat_app.services.RoomService;
import com.chat_app.backend_chat_app.services.UserService;

@Controller
public class ChatController {

  @Autowired
  public RoomService roomService;

  @Autowired
  public MessageService messageService;

  @Autowired
  public UserService userService;

  @MessageMapping("/sendMessage/{roomId}")
  @SendTo("/topic/room/{roomId}")
  public Message sendMessage(
      @DestinationVariable String roomId,
      @RequestBody MessageRequest request) {

    Message message = new Message();
    message.setMessageContent(request.getMessageContent());
    User user = this.userService.getUserByUserId(request.getUserId());
    message.setUser(user);
    message.setTimeStamp(LocalDateTime.now());

    Room room = this.roomService.getRoomByRoomId(roomId);
    this.messageService.addMessageInRoom(room, message);
    return message;
  }
}