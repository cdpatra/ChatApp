package com.chat_app.backend_chat_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.chat_app.backend_chat_app.services.RoomService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class RoomController {

  @Autowired
  public RoomService roomService;

  @PostMapping("/room/{userId}/{roomName}")
  public ResponseEntity<?> createRoom(@PathVariable("userId") int userId,
      @PathVariable("roomName") String roomName) {

    String roomId = this.roomService.createRoom(userId, roomName);
    return new ResponseEntity<>(Map.of("roomId", roomId), HttpStatus.OK);
  }

}
