package com.cg.employeedetail.service;

import com.cg.employeedetail.model.Company;
import com.cg.employeedetail.model.Employee;
import com.cg.employeedetail.repository.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyDAO companyDAO;

    public Optional<Company> save(Company company) {
        try {
            companyDAO.save(company);
            System.out.println("Hello " + company);
            return Optional.of(company);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
            return Optional.empty();
        }
    }
}
