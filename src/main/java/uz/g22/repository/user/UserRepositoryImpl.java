package uz.g22.repository.user;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;

import java.util.List;
import java.util.UUID;
@Repository
public class UserRepositoryImpl implements UserRepository{
  String updateRole = "update users set role =:role where id = :id";
    String DELETE = "delete from users where id = :id";
    @PersistenceContext
    private  EntityManager entityManager;



    @Override
    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getById(UUID id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
     entityManager.createQuery(DELETE)
             .setParameter("id",id)
             .executeUpdate();
    }

    @Override

    public User update(User update) {
        return entityManager.merge(update);
    }

    @Override
    public User getByEmail(String email) {
        return entityManager.createQuery(GET_BY_USERNAME, User.class)
                .setParameter("email",email)
                .getSingleResult();
    }

    @Override
    public void updateRole(UserRole role, UUID id) {
        entityManager.createQuery(updateRole)
                .setParameter("role", role)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(GET_ALL_USERS, User.class)
                .getResultList();
    }
}
