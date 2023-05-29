package com.example.customerms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Customer API", version = "1.0.0"),
        servers = {@Server(url = "http://localhost:8081")},
        tags = {@Tag(name = "CustomerMS", description = "API to add/list a customer/customers")}
)
public class CustomerMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMsApplication.class, args);
    }

}
