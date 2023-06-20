package uz.g22.repository.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.product.Product;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    String GET_USER_PRODUCTS = "select p from product p where p.user.id = :ownerId";
    String DELETE = "delete  from  product p  where p.id = :id";
//    drop table if exists orders cascade;
    String ALL_PRODUCTS = "select p from product p ";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product getById(UUID id) {
        return entityManager.find(Product.class,id);
    }

    @Override
 @Transactional
    public void deleteById(UUID id) {
    entityManager.createQuery(DELETE)
            .setParameter("id",id)
            .executeUpdate();
    }

    @Override
//    @Transactional
    public Product update(Product update) {
        entityManager.merge(update);
        return update;
    }

    @Override

    public List<Product> getUserProduct(UUID id) {
        return entityManager.createQuery(GET_USER_PRODUCTS, Product.class)
                .setParameter("ownerId", id)
                .getResultList();
    }

    @Override
    public List<Product> allProducts() {
       return entityManager.createQuery(ALL_PRODUCTS, Product.class)
                .getResultList();

    }

}
