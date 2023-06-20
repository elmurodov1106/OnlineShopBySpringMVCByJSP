package uz.g22.service.order;

import jakarta.persistence.criteria.Order;
import uz.g22.dto.OrderCreateDto;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.order.OrderEntity;
import uz.g22.entity.product.Product;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    int add(OrderCreateDto order, UUID owner_id,UUID product_id);

    List<OrderEntity> getUserOrders(UUID ownerId);

    void deleteById(UUID id);
    OrderEntity getById(UUID id);

    OrderEntity update(OrderCreateDto update,UUID id,UUID userId);
    List<OrderEntity> getAllOrders();
}
