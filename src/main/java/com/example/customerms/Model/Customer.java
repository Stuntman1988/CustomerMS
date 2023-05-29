package com.example.customerms.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "\"ssn\" can not be empty!\n")
    @Size(min = 8, max = 10, message = "\"ssn\" must be between 8 and 10 characters.\n")
    private String ssn;

    @NotEmpty(message = "\"name\" can not be empty!\n")
    @Size(min = 2, max = 20, message = "\"name\" must be between 2 and 20 characters.\n")
    private String name;

    public Customer(String ssn, String name) {
        this.name = name;
        this.ssn = ssn;
    }
}
