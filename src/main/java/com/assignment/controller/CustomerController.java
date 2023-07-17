package com.assignment.controller;

import com.assignment.dto.CustomerDTO;
import com.assignment.service.CustomerInterface;
import com.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerInterface.getAllCustomers();
    }
}