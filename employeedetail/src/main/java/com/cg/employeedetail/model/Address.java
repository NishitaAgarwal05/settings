package com.cg.employeedetail.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id", scope = Employee.class)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="add_line1")
    private String addLine1;

    @Column(name="add_line2")
    private String addLine2;

    @Column(name="city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name="pincode")
    private String pincode;

    public Address(AddressDetailRequest add) {
        this.addLine1 = add.getAddLine1();
        this.addLine2 = add.getAddLine2();
        this.city = add.getCity();
        this.country = add.getCountry();
        this.pincode = add.getPincode();
    }

   }
