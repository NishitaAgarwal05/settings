package com.cg.employeedetail.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AddressDetailRequest {
    private String addLine1;

    private String addLine2;

    private String city;

    private String country;

    private String pincode;
}
