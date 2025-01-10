package com.scalerecom.scalerecom.repository;

import com.scalerecom.scalerecom.Models.Ordermodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordermodel, String> {

    Ordermodel save(Ordermodel ordermodel);
}
