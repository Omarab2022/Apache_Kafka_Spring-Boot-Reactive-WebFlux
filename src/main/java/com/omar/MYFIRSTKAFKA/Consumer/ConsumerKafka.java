package com.omar.MYFIRSTKAFKA.Consumer;


import com.omar.MYFIRSTKAFKA.Payload.Students;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerKafka {


//	@KafkaListener(topics = "OMAR_TOPIC", groupId = "mygroup")
	public void ConsumMsg(String message){
		log.info(String.format("Consuming message from OMAR_TOPIC: %s", message));
	}

	@KafkaListener(topics = "OMAR_TOPIC", groupId = "mygroup")
	public void ConsumJSONMsg(Students students){
		log.info(String.format("Consuming message from OMAR_TOPIC: %s", students.toString()));
	}
}
