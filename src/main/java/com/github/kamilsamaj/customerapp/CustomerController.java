package com.github.kamilsamaj.customerapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  private CustomerRepository repository;

  @GetMapping("/customer")
  List<Customer> all() {
    return repository.findAll();
  }

  @GetMapping("/customer/{id}")
  Customer get(@PathVariable Long id) {
    return repository
        .findById(id)
        .orElseThrow(
            () -> new CustomerNotFoundException(id));
  }

  @PostMapping("/customer")
  Customer save(@RequestBody Customer newCustomer) {
    return repository.save(newCustomer);
  }

  @PutMapping("/customer/{id}")
  Customer update(@PathVariable Long id, @RequestBody Customer newCustomer){
    return repository.findById(id).map(customer -> {
      customer.setEmail(newCustomer.getEmail());
      customer.setName(newCustomer.getName());
      return customer;
    }).orElseGet(() -> {
      newCustomer.setId(id);
      return repository.save(newCustomer);
    });
  }

  @DeleteMapping("/customer/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
