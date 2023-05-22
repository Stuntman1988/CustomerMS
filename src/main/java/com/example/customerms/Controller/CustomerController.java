package com.example.customerms.Controller;
import com.example.customerms.Model.Customer;
import com.example.customerms.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }


    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
