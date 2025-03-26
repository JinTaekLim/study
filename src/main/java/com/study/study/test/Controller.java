package com.study.study.test;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/test")
    public void test(String topic){
        LocalDateTime now = LocalDateTime.now();
        kafkaProducer.sendMessage(topic, String.valueOf(now.getMinute()), String.valueOf(now.getSecond()));
    }
}
