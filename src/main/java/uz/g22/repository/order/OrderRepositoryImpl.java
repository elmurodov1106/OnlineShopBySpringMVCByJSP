package uz.g22.repository.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.entity.order.OrderEntity;

import java.util.List;
import java.util.UUID;
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{

    String GET_USER_ORDERS = "select o from orders o where o.user.id = :userId";
    String DELETE = "delete from orders o where o.id = :id";
    String ALL_ORDERS = " select o from orders o";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public OrderEntity save(OrderEntity order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public OrderEntity getById(UUID id) {
        return entityManager.find(OrderEntity.class,id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
      entityManager.createQuery(DELETE)
              .setParameter("id",id)
              .executeUpdate();
    }

    @Override
    @Transactional
    public OrderEntity update(OrderEntity update) {
        entityManager.merge(update);
        return update;
    }

    @Override
    public List<OrderEntity> getUserOrders(UUID id) {
        return entityManager.createQuery(GET_USER_ORDERS, OrderEntity.class)
                .setParameter("userId", id)
                .getResultList();
    }

    @Override
    public List<OrderEntity> allOrders() {
        return entityManager.createQuery(ALL_ORDERS, OrderEntity.class)
                .getResultList();
    }
}
