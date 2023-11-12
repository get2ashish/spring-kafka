package github.com.get2ashish.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaTopicListener {
    @KafkaListener(topics = "${topic.name}", groupId = "CG1")
    public void onMessage(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partitionId,
            @Header(KafkaHeaders.OFFSET) String offset){
        log.info("Message received {} Partition {} Offset {}", message, partitionId, offset);
    }
}
