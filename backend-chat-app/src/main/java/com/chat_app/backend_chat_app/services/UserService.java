package com.chat_app.backend_chat_app.services;

import java.util.List;

import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.entities.User;
import com.chat_app.backend_chat_app.payloads.ApiResponse;
import com.chat_app.backend_chat_app.payloads.RegisterDto;

public interface UserService {
public User getUserByUserId(int userId);
public ApiResponse addUser(RegisterDto userDto);
public List<Room> getAllRooms(int userId);
}
