package com.Producer.Service;


import com.Producer.Entity.Producer;
import com.Producer.Repository.ProducerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProducerKafka {

    @Autowired
    ProducerRepository producerRepository;
    @Autowired
    private KafkaTemplate<String, Producer>kafkaTemplate;

    private static  final String TOPIC="Producer-Kafka";

    public Producer sendproducer(Producer producer){
        Producer save=producerRepository.save(producer);
        kafkaTemplate.send(TOPIC,save);

        return save;
    }

    public List<Producer> getAll(){
        return producerRepository.findAll();
    }

}
