package uz.g22.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.entity.card.CardEntity;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

    String GET_USER_CARDS = "select c from cards c where c.user.id = :ownerId";
    String DELETE = "delete from cards c where c.id = :id";
    String ALL_CARDS = "select c from cards c ";
    String UPDATE_BALANCE = "update cards c set balance = balance-:amount where c.id= :id";
//    String INSERT_CARD = "insert into cards(card_number,balance,expire_date,card_type) values (:number,:balance,:date,:type)";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public CardEntity save(CardEntity cardEntity) {
//        CardEntity singleResult = entityManager.createQuery(INSERT_CARD, CardEntity.class)
//                .setParameter("number", cardEntity.getCard_number())
//                .setParameter("balance", cardEntity.getBalance())
//                .setParameter("date", cardEntity.getExpire_date())
//                .setParameter("type", cardEntity.getCard_type())
//                .getSingleResult();
        entityManager.persist(cardEntity);
        return cardEntity;
    }

    @Override
    public CardEntity getById(UUID id) {
      return entityManager.find(CardEntity.class,id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        entityManager.createQuery(DELETE)
                .setParameter("id",id).executeUpdate();

    }

    @Override
    public CardEntity update(CardEntity update) {
       return   entityManager.merge(update);

    }

    @Override
    public List<CardEntity> getUserCard(UUID id) {

        return entityManager.createQuery(GET_USER_CARDS, CardEntity.class)
                .setParameter("ownerId", id)
                .getResultList();
    }

    @Override
    @Transactional
    public void updateBalance(UUID cardId,Double amount) {
        entityManager.createQuery(UPDATE_BALANCE)
                .setParameter("amount",amount)
                .setParameter("id",cardId).executeUpdate();

    }

    @Override
    public List<CardEntity> allCards() {
        return entityManager.createQuery(ALL_CARDS, CardEntity.class)
                .getResultList();
    }

//    @Override
//    public void transaction(UUID cardId, UUID userId) {
//        entityManager.createQuery(UPDATE_BALANCE)
//    }
}
