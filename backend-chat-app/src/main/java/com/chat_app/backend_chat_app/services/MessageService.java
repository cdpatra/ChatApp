package com.chat_app.backend_chat_app.services;

import com.chat_app.backend_chat_app.entities.Message;
import com.chat_app.backend_chat_app.entities.Room;

public interface MessageService {
void addMessageInRoom(Room room, Message message);
}
