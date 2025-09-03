package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
