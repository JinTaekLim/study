package com.study.study;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMqProperties {
  private List<QueueConfig> queues;

  @Getter
  @Setter
  public static class QueueConfig {
    private String name;
    private String exchange;
    private String routingKey;
  }
}
