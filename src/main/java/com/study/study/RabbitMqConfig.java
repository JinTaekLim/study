package com.study.study;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitMqProperties.class)
@RequiredArgsConstructor
public class RabbitMqConfig {

  private final RabbitMqProperties rabbitMqProperties;
  @Bean
  public Declarables rabbitDeclarables() {
    List<Queue> queues = rabbitMqProperties.getQueues().stream()
        .map(q -> new Queue(q.getName(), true))
        .toList();

    return new Declarables(queues);
  }
}
