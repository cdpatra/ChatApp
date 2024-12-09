package com.chat_app.backend_chat_app.payloads;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
  private int userId;
  private String messageContent;
  private String roomId;
  private LocalDateTime timeStamp;
}
