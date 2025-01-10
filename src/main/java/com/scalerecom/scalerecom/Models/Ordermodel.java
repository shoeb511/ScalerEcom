package com.scalerecom.scalerecom.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ordermodel extends BaseModel {
    private long customerId;
    private long amount;

    @ElementCollection
    private List<Long> productIdList = new ArrayList<>();

    enum OrderState {
        PENDING,
        CONFIRMED,
        SHIPPED,
        DELIVERED,
        CANCELED
    }

    @Enumerated(EnumType.STRING)
    private OrderState orderState = OrderState.PENDING;

    public Ordermodel() {

    }

    public Ordermodel(long customerId, long amount, List<Long> productIdList) {
        this.customerId = customerId;
        this.amount = amount;
        this.productIdList = productIdList;
    }



    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "Ordermodel{" +
                ", productIdList=" + productIdList +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", orderState=" + orderState +
                '}';
    }
}
