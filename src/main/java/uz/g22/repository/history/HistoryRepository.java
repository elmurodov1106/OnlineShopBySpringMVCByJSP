package uz.g22.repository.history;

import uz.g22.entity.history.History;
import uz.g22.entity.order.OrderEntity;
import uz.g22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends BaseRepository<History> {
    List<History> getUserHistories(UUID id);

    List<History> allHistories();
}
