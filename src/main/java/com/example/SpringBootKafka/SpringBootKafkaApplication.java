package com.example.SpringBootKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBootKafkaApplication {
        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;
  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

        public void run(ApplicationArguments args) throws Exception {
            sendMessage("Hi Welcome to Spring For Apache Kafka");
       }
        
       public void sendMessage(String msg) {
          kafkaTemplate.send("Test topic:", msg);
       }
       
         @KafkaListener(topics = "test", groupId = "group-id")
        public void listen(String message) {
            System.out.println("Received Messasge in group - group-id: " + message);
        }
}
