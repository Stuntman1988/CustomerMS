package com.example.customerms.Controller;
import com.example.customerms.Model.Customer;
import com.example.customerms.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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
    public String addCustomer(@RequestBody @Valid Customer customer, BindingResult bndResult){
        if (bndResult.hasErrors()){
            return ResponseEntity.badRequest().body(bndResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).collect(Collectors.joining())).getBody();
        }
        return customerService.addCustomer(customer);
    }
}
