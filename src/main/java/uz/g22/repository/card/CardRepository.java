package uz.g22.repository.card;

import uz.g22.entity.card.CardEntity;
import uz.g22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends BaseRepository<CardEntity> {
    List<CardEntity> getUserCard(UUID id);
     void updateBalance(UUID cardId,Double amount);
    List<CardEntity> allCards();
//    void transaction(UUID cardId,UUID userId);
}
