package com.chat_app.backend_chat_app.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfigurations {

  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
