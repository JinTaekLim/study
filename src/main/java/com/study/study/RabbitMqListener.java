package com.study.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqListener {

  private final String customerQueueName = "customer_queue";
  private final String reservationQueueName = "reservation_queue";

  @RabbitListener(queues = customerQueueName)
  public void reciveMessage(String message) {
    log.info("수신 : " + message);
  }

  @RabbitListener(queues = reservationQueueName)
  public void reservation(String message) {
    log.info("R 수신 : " + message);
  }
}
