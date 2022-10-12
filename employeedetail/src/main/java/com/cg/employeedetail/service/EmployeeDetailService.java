package com.cg.employeedetail.service;

import com.cg.employeedetail.model.Employee;
import com.cg.employeedetail.model.EmployeeDetailRequest;
import com.cg.employeedetail.repository.EmployeeDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailService {

    @Autowired
    public  EmployeeDetailDAO employeeDetailDAO;

    public  List<Employee> listAllEmployeesByCompany(String companyName) {
        List listOfEmployees = new ArrayList<>();
        for (Employee e:employeeDetailDAO.findAll()) {
            if(e.getCompany().getCompanyName().equalsIgnoreCase(companyName))
                listOfEmployees.add(e);
        }
        return listOfEmployees;
    }

    public Optional<Employee> save(Employee employee) {
        try{
            employeeDetailDAO.save(employee);
            System.out.println("Hello " + employee);
            return Optional.of(employee);
        }
        catch (Exception e) {
            System.out.println("Exception"+e.getMessage());
            return Optional.empty();
        }
    }
}
