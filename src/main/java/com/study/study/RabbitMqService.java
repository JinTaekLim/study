package com.study.study;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqService {

  private final RabbitTemplate rabbitTemplate;

  public void sendMessage(String queueName, String message) {
    rabbitTemplate.convertAndSend(queueName, message);
  }
}
