package com.Producer.Controller;


import com.Producer.Entity.Producer;
import com.Producer.Repository.ProducerRepository;
import com.Producer.Service.ProducerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class producerController {
@Autowired
    ProducerKafka producerKafka;

@PostMapping("/send")
public Producer send(@RequestBody Producer producer){
    return producerKafka.sendproducer(producer);
}
@GetMapping("/get")
public List<Producer> getAll(Producer producer){
    return producerKafka.getAll();
}



@GetMapping("/check")
public String Fun(){
    return "Welcome to Git World";
}

}
