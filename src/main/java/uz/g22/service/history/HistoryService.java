package uz.g22.service.history;

import uz.g22.dto.HistoryCreateDto;
import uz.g22.dto.OrderCreateDto;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.history.History;
import uz.g22.entity.order.OrderEntity;
import uz.g22.entity.product.Product;

import java.util.List;
import java.util.UUID;

public interface HistoryService {
    int add(ProductCreateDto history,UUID id, UUID owner_id);
//    int addOrder(OrderCreateDto history, UUID id, UUID owner_id);


    List<History> getUserHistories(UUID ownerId);
    History getById(UUID id);
    void deleteById(UUID id);

    List<History> getAllHistories();
}
