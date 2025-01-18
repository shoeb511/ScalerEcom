package com.scalerecom.scalerecom.Services;

import com.scalerecom.scalerecom.Models.Ordermodel;
import com.scalerecom.scalerecom.repository.OrderRepository;
import com.scalerecom.scalerecom.repository.ProductRepository;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    //PaymentService paymentService;
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }



    public ResponseEntity<Ordermodel> getOrder(List<Long> productIds, long customerId, long amount) throws StripeException {
        Ordermodel order = new Ordermodel();
        order.setCustomerId(customerId);
        order.setAmount(amount);
        order.setProductIdList(productIds);
        orderRepository.save(order);
        //paymentService.makePayment(order.getId(), amount);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    //webhook service to change the order status if the payment has been succeeded
    // public ResponseEntity<String> checkPaymentStatus
    public String orderStatus(long orderId) {
        orderRepository.updateOrderState(orderId);
        Ordermodel order = new Ordermodel();
        order = orderRepository.getById(String.valueOf(orderId));
        return order.toString();
    }
}
