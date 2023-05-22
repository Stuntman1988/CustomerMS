package com.example.customerms.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String ssn;
    private String name;

    public Customer(String ssn, String name) {
        this.name = name;
        this.ssn = ssn;
    }
}
