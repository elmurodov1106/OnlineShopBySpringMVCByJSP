package uz.g22.repository.history;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.entity.history.History;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepository{
    String DELETE = "delete from histories h where h.id = :id";
    String ALL_HISTORIES = " select h from histories h";
    String GET_USER_HISTORIES = " select h from histories h where h.users.id = :id";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public History save(History history) {
        entityManager.persist(history);
        return history;
    }

    @Override
    public History getById(UUID id) {
        return entityManager.find(History.class,id);
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
    public History update(History update) {
        return null;
    }

    @Override
    public List<History> getUserHistories(UUID id) {
        return entityManager.createQuery(GET_USER_HISTORIES, History.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<History> allHistories() {
        return entityManager.createQuery(ALL_HISTORIES, History.class)
                .getResultList();
    }
}
