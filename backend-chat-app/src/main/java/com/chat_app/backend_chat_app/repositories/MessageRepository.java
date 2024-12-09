package com.chat_app.backend_chat_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat_app.backend_chat_app.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
