package com.omar.MYFIRSTKAFKA.Controllers;


import com.omar.MYFIRSTKAFKA.Producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/messages")
@RestController
@RequiredArgsConstructor
public class MessageController {

	private final KafkaProducer kafkaProducer;


	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the Kafka Topic OMAR_TOPIC");
	}
}
