package com.chat_app.backend_chat_app.services;

import com.chat_app.backend_chat_app.entities.Room;

public interface RoomService {
  public Room getRoomByRoomId(String roomId);
  public String createRoom(int userId, String roomName);
}
