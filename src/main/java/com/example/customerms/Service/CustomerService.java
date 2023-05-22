package com.example.customerms.Service;

import com.example.customerms.Model.Customer;
import com.example.customerms.Repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public String addCustomer(Customer customer) {
        if (customer.getName() != null) {
            if (customer.getSsn() != null) {
                customerRepo.save(customer);
                return "Customer with name: " + customer.getName() + " added.";
            }
        }
        return "Could not add customer!";
    }

}
