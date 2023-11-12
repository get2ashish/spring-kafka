package github.com.get2ashish.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Value("${topic.name}")
    String topicName;

    @PostMapping
    public ResponseEntity<String> postMessage(@RequestBody String payload){
        kafkaTemplate.send(topicName, payload);
        return new ResponseEntity<>("message published", HttpStatus.ACCEPTED);
    }
}
