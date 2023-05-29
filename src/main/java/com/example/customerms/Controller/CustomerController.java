package com.example.customerms.Controller;
import com.example.customerms.Model.Customer;
import com.example.customerms.Service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @Operation(
            tags = {"Customer"},
            operationId = "listCustomers",
            description = "List all Customers",
            responses = {@ApiResponse(responseCode = "200",
            content = @Content(schema =
            @Schema(implementation = Customer.class),
            mediaType = MediaType.APPLICATION_JSON_VALUE),
                    description = "Successful response" )}
    )
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @GetMapping("/{id}")
    @Operation(
            tags = {"Customer"},
            operationId = "getSingleCustomer",
            description = "get a Customer by their ID",
            responses = {@ApiResponse(responseCode = "200",
            content = @Content(schema =
            @Schema(implementation = Customer.class), mediaType = MediaType.APPLICATION_JSON_VALUE),
            description = "Successful response")}
    )
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/add")
    @Operation(
            tags = {"Customer"},
            operationId = "addCustomer",
            description = "Add a Customer to DB",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = Customer.class))
            ),
            responses = {@ApiResponse(responseCode = "200",
            content = @Content(schema =
            @Schema(implementation = Customer.class),
            mediaType = MediaType.APPLICATION_JSON_VALUE),
            description = "Successful response")}
    )
    public String addCustomer(@RequestBody @Valid Customer customer, BindingResult bndResult){
        if (bndResult.hasErrors()){
            return ResponseEntity.badRequest().body(bndResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).collect(Collectors.joining())).getBody();
        }
        return customerService.addCustomer(customer);
    }
}
