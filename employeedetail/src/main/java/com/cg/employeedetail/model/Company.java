package com.cg.employeedetail.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="company")
@ToString
@Getter
@Setter
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id", scope = Employee.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="company_building")
    private String companyBuilding;

    @Column(name="company_city")
    private String companyCity;

//    @OneToMany(mappedBy = "company")
//    private List<Employee> employees;

    public Company(CompanyDetailRequest company) {
        this.companyName = company.getCompanyName();
        this.companyBuilding = company.getCompanyBuilding();
        this.companyCity = company.getCompanyCity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
