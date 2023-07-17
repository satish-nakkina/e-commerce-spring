package com.assignment.controller;

import com.assignment.dto.OrderDTO;
import com.assignment.service.OrderInterface;
import com.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderInterface orderInterface;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderInterface.getAllOrders();
    }
}