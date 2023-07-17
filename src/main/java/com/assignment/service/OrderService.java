package com.assignment.service;

import com.assignment.dto.CustomerDTO;
import com.assignment.dto.OrderDTO;
import com.assignment.dto.ProductDTO;
import com.assignment.entities.Customer;
import com.assignment.entities.Order;
import com.assignment.entities.Product;
import com.assignment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderInterface{
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setCustomer(convertToCustomerDTO(order.getCustomer()));
        dto.setProducts(order.getProducts().stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private CustomerDTO convertToCustomerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        return dto;
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }
}