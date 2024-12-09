package com.chat_app.backend_chat_app.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat_app.backend_chat_app.entities.Room;
import com.chat_app.backend_chat_app.entities.User;
import com.chat_app.backend_chat_app.exceptions.ResourceNotFoundException;
import com.chat_app.backend_chat_app.payloads.ApiResponse;
import com.chat_app.backend_chat_app.payloads.RegisterDto;
import com.chat_app.backend_chat_app.repositories.UserRepository;
import com.chat_app.backend_chat_app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  public UserRepository userRepository;

  @Autowired
  public ModelMapper modelMapper;

  @Override
  public User getUserByUserId(int userId) {
    return this.userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User", "user ID", userId));
  }

  @Override
  public ApiResponse addUser(RegisterDto registerDto) {
    User user = this.modelMapper.map(registerDto, User.class);
    boolean isUserExists = this.userRepository.findByUsername(user.getUsername()).isPresent();
    if (!isUserExists) {
      this.userRepository.save(user);
      return new ApiResponse("Registration Successful !",true);
    }else{
      return new ApiResponse("User already Exist !",false);
    }
  }

  @Override
  public List<Room> getAllRooms(int userId) {
    User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user ID", userId));
    return user.getRooms();
  }

  
}
