package com.github.kamilsamaj.customerapp;

public class Customer {

  public Customer(String email, String name) {
    this.email = email;
    this.name = name;
  }

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
