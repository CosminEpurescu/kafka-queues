package com.ing.api.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class TopicController {
    private final KafkaAdmin kafkaAdmin;

    @GetMapping("/topic/create/{topic-name}")
    public String helloWorld(@PathVariable("topic-name") String topicName) {
        kafkaAdmin.createOrModifyTopics(new NewTopic(topicName, 1, (short) 1));

        return kafkaAdmin.describeTopics(topicName).toString();
    }
}
