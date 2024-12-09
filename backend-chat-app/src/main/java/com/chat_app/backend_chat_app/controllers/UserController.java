package com.chat_app.backend_chat_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.payloads.ApiResponse;
import com.chat_app.backend_chat_app.payloads.RegisterDto;
import com.chat_app.backend_chat_app.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

  @Autowired
  public UserService userService;
  
  @PostMapping("/user/register")
  public ResponseEntity<?> registerUserHandler(@RequestBody RegisterDto registerDto) {
      ApiResponse apiResponse = this.userService.addUser(registerDto);
      return new ResponseEntity<>(apiResponse,HttpStatus.OK);
  }
  
  @GetMapping("/user/{userId}/all-rooms")
  public ResponseEntity<?> getAllRooms(@PathVariable("userId") int userId){
    List<Room> allRooms = this.userService.getAllRooms(userId);
    return new ResponseEntity<>(allRooms,HttpStatus.OK);
  }
  
}
