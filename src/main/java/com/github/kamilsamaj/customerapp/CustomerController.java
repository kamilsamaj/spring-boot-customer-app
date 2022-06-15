package com.github.kamilsamaj.customerapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    Customer all() {
        return new Customer("kamilsamaj@gmail.com", "Kamil Samaj");
    }
}
