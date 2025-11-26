package com.marly.demo.Domain.Repository;

import com.marly.demo.Domain.OrderItem;
import java.util.List;
import java.util.Optional;

public interface  OrderItemRepository {
    List<OrderItem> getAll();
    Optional<OrderItem> getOrderItem(Integer orderItemId);
    List<OrderItem> getByOrder(Integer orderId);
    OrderItem save(OrderItem orderItem);
    void delete(Integer orderItemId);
}
