package com.cg.employeedetail.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
public class EmployeeDetailRequest {
    private String firstName;

    private String lastName;

    private String contactNo;

    private AddressDetailRequest address;

    private CompanyDetailRequest company;
}
