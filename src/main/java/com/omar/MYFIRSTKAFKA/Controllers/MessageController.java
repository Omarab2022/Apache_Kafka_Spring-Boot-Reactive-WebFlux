package com.omar.MYFIRSTKAFKA.Controllers;


import com.omar.MYFIRSTKAFKA.Payload.Students;
import com.omar.MYFIRSTKAFKA.Producer.KafkaJsonProducer;
import com.omar.MYFIRSTKAFKA.Producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/messages")
@RestController
@RequiredArgsConstructor
public class MessageController {

	private final KafkaProducer kafkaProducer;

	private final KafkaJsonProducer kafkaJsonProducer;

	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the Kafka Topic OMAR_TOPIC");
	}


	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody Students message){
		kafkaJsonProducer.sendMessage(message);
		return ResponseEntity.ok("Message Json sent to the Kafka Topic OMAR_TOPIC as JSON");
	}
}
