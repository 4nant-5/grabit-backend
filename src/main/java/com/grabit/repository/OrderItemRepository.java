package com.grabit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabit.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
