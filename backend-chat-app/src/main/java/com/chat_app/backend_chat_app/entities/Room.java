package com.chat_app.backend_chat_app.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
  @Id
  private String roomId;
  @Column(unique = true)
  private String roomName;
  @ManyToOne
  @JsonBackReference
  private User user;
  @ElementCollection
  private List<Message> messages = new ArrayList<>();
}
