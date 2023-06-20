package uz.g22.repository.order;

import jakarta.persistence.criteria.Order;
import uz.g22.entity.order.OrderEntity;
import uz.g22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends BaseRepository<OrderEntity> {
    List<OrderEntity> getUserOrders(UUID id);

    List<OrderEntity> allOrders();
}
