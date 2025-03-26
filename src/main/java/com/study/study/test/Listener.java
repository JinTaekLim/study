package com.study.study.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

  @KafkaListener(topics = "a-topic", groupId = "a-topic-group")
  public void a(ConsumerRecord<String, Object> record) throws InterruptedException {
    System.out.print("A " + record.key());
    System.out.println(" / " + record.value());
  }

  @KafkaListener(topics = "b-topic", groupId = "b-topic-group")
  public void b(ConsumerRecord<String, Object> record) throws InterruptedException {
    System.out.print("B " + record.key());
    System.out.println(" / " + record.value());
  }

  @KafkaListener(topics = "c-topic", groupId = "c-topic-group")
  public void c(ConsumerRecord<String, Object> record) throws InterruptedException {
    System.out.print("C" + record.key());
    System.out.println(" / " + record.value());
  }


}