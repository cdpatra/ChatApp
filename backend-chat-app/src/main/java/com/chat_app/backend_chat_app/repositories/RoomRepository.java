package com.chat_app.backend_chat_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat_app.backend_chat_app.entities.Room;
import java.util.Optional;


@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
  Optional<Room> findByRoomName(String roomName);
}
