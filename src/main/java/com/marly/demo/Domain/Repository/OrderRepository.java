package com.marly.demo.Domain.Repository;

import com.marly.demo.Domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAll();
    Optional<Order> getOrder(Integer orderId);
    List<Order> getByUser(Integer UserId);
    Order save(Order order);
    void delete(Integer orderId);
}
