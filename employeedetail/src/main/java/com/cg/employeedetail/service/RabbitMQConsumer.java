package com.cg.employeedetail.service;

import com.cg.employeedetail.model.Address;
import com.cg.employeedetail.model.Company;
import com.cg.employeedetail.model.EmployeeDetailRequest;
import com.cg.employeedetail.repository.AddressDAO;
import com.cg.employeedetail.repository.CompanyDAO;
import com.cg.employeedetail.repository.EmployeeDetailDAO;
import com.cg.employeedetail.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.util.UUID;

@Component
public class RabbitMQConsumer implements RabbitListenerConfigurer {


    EmployeeDetailService employeeDetailService;
    AddressDAO addressDAO;
    CompanyDAO companyDAO;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receivedMessage(Message msg){
//        Address add = new Address(req.getAddress());
//        //        System.out.println(add);
        System.out.println("Consuming message - " + msg.getBody());
        try{
            ObjectMapper om = new ObjectMapper();
            EmployeeDetailRequest req = om.readValue(msg.getBody(),EmployeeDetailRequest.class);
//        emp.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
//        emp.getAddress().setId(UUID.randomUUID().getMostSignificantBits()&Long.MAX_VALUE);
//        emp.getCompany().setId(UUID.randomUUID().getMostSignificantBits()&Long.MAX_VALUE);
//            Address add =new Address(req.getAddress());
//            System.out.println(add);
//            addressDAO.save(add);
            Employee emp = new Employee(req);
            System.out.println(emp);
            employeeDetailService.save(emp);
//            addressDAO.save(emp.getAddress());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//            addressDAO.save(req.getAddress());
        //        companyDAO.save(company);
//                employeeDetailService.save(req);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }



    /*private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Autowired
    public RabbitMQConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private String receiveMessage(){
        String emp = (String)rabbitTemplate.receiveAndConvert(queueName);
        return emp;
    }
    public Employee processMessage() throws JsonProcessingException{
        String emp =receiveMessage();
        return new ObjectMapper().readValue(emp,Employee.class);
    }

     */

}

