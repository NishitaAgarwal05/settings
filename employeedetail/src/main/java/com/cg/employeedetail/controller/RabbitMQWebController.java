package com.cg.employeedetail.controller;

import com.cg.employeedetail.model.Employee;
import com.cg.employeedetail.model.EmployeeDetailRequest;
import com.cg.employeedetail.service.EmployeeDetailService;
import com.cg.employeedetail.service.RabbitMQConsumer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class RabbitMQWebController {

    @Autowired
    EmployeeDetailService employeeDetailService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RabbitMQConsumer rabbitMQConsumer;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @PostMapping("/produce")
    public String produceMessage(@RequestBody EmployeeDetailRequest employee){
        template.convertAndSend(exchange,routingkey,employee);
        return "Employee details sent successfully";
    }

    @GetMapping("/{companyName}")
    public ResponseEntity<List<Employee>> listAllEmployessByCompany(@PathVariable("companyName") String companyName){
        List<Employee> listOfEmployees = employeeDetailService.listAllEmployeesByCompany(companyName);
        return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
    }

//    @GetMapping("/consume")
//    @RabbitListener(queues = {"${rabbitmq.queue}"})
//    public String displayData(Employee employee){
//        System.out.println(employee);
//        return "Employee details consumed successfully";
//    }


//    @GetMapping("/consume")
//    public ResponseEntity<?> getEmployee() throws JsonProcessingException{
//        Employee emp = rabbitMQConsumer.processMessage();
//        System.out.println("Employee details sent successfully!");
//        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
//    }

}

