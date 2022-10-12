package com.cg.employeedetail.repository;

import com.cg.employeedetail.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDAO extends JpaRepository<Company,Long> {
}
