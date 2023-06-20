package uz.g22.service.card;

import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.card.CardEntity;
import uz.g22.entity.product.Product;

import java.util.List;
import java.util.UUID;

public interface CardService {
    int add(CardEntity card, UUID userId);

    List<CardEntity> getUserCards(UUID ownerId);

    void deleteById(UUID id);
    CardEntity getById(UUID id);

    CardEntity update(CardEntity update,UUID ownerId);
    void updateBalance(UUID cardId,Double amount);

    List<CardEntity> getAllCards();
}
