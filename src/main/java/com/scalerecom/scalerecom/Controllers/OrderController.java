package com.scalerecom.scalerecom.Controllers;

import com.scalerecom.scalerecom.Models.Ordermodel;
import com.scalerecom.scalerecom.Services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Ordermodel> order(@RequestBody Ordermodel ordermodel) {

        return orderService.getOrder(ordermodel.getProductIdList(), ordermodel.getCustomerId(), ordermodel.getAmount());

    }
}
