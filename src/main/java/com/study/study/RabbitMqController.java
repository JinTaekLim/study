package com.study.study;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rabbit")
@RequiredArgsConstructor
public class RabbitMqController {

  private final RabbitMqService rabbitMqService;

  @PostMapping("/send")
  public void send(String queueName, String message) {
    rabbitMqService.sendMessage(queueName, message);
  }
}
