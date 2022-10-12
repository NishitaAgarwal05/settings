package com.cg.employeedetail.repository;

import com.cg.employeedetail.model.Employee;
import com.cg.employeedetail.model.EmployeeDetailRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailDAO extends JpaRepository<Employee, Long> {

}
