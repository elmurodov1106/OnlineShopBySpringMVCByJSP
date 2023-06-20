package uz.g22.service.card;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.g22.entity.card.CardEntity;
import uz.g22.entity.product.Product;
import uz.g22.entity.user.User;
import uz.g22.repository.card.CardRepository;
import uz.g22.repository.user.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public int add(CardEntity card, UUID userId) {

   CardEntity card1
            = new CardEntity();
//        userRepository.getById(userId);
        card1.setUser(userRepository.getById(userId));
        card1.setCard_type(card.getCard_type());
        card1.setExpire_date(card.getExpire_date());
        card1.setBalance(card.getBalance());
        card1.setNumber(card.getNumber());
        card1.setPassword(card.getPassword());
        cardRepository.save(card1);
        return 1;
    }

    @Override
    public List<CardEntity> getUserCards(UUID ownerId) {
        return cardRepository.getUserCard(ownerId);
    }

    @Override
    public void deleteById(UUID id) {
       cardRepository.deleteById(id);
    }

    @Override
    public CardEntity getById(UUID id) {
        return cardRepository.getById(id);
    }

    @Override
    public CardEntity update(CardEntity update, UUID ownerId) {

            modelMapper.getConfiguration()
                    .setPropertyCondition(Objects::nonNull)
                    .setPropertyCondition(Conditions.isNotNull());

           return cardRepository.update(update);


    }

    @Override
    public void updateBalance(UUID cardId, Double amount) {
        cardRepository.updateBalance(cardId,amount);
    }

    @Override
    public List<CardEntity> getAllCards() {
        return cardRepository.allCards();
    }
}
