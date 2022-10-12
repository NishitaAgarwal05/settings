package com.cg.employeedetail.repository;

import com.cg.employeedetail.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address,Long> {
}
