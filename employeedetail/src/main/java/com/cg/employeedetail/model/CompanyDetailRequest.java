package com.cg.employeedetail.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
public class CompanyDetailRequest {
    private String companyName;

    private String companyBuilding;

    private String companyCity;
}
