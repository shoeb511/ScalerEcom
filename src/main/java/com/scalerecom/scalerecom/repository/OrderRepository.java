package com.scalerecom.scalerecom.repository;

import com.scalerecom.scalerecom.Models.Ordermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Ordermodel, String> {

    Ordermodel save(Ordermodel ordermodel);

    @Query(value = "update 'Ordermodel' set OrderState = 'CONFIRMED' where orderId = orderId", nativeQuery = true)
    Ordermodel updateOrderState(long orderid);
}
