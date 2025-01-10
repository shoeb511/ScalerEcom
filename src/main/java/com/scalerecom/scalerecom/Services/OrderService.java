package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Ordermodel;
import com.scalerecom.scalerecom.repository.OrderRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }



    public ResponseEntity<Ordermodel> getOrder(List<Long> productIds, long customerId, long amount) {
        Ordermodel order = new Ordermodel();
        order.setCustomerId(customerId);
        order.setAmount(amount);
        order.setProductIdList(productIds);
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
