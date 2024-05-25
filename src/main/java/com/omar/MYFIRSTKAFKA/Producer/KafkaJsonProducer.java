package com.omar.MYFIRSTKAFKA.Producer;


import com.omar.MYFIRSTKAFKA.Payload.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;


	public void sendMessage(Students students){

		Message<Students> message  = MessageBuilder.withPayload(students)
				.setHeader(KafkaHeaders.TOPIC , "OMAR_TOPIC").build();

		kafkaTemplate.send(message);
	}
}
