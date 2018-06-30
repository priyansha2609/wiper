package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper
{
    Order getOrderById(Integer orderId);
    Integer upsertOrder(Map<String, Object> params);
    List<Order> getOrdersByCustomerId(Integer customerId);
}