package uz.g22.repository.product;

import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.product.Product;
import uz.g22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getUserProduct(UUID id);

   List<Product> allProducts();

    //String GET_USER_PRODUCTS = "select p from product p where p.owner_id = :ownerId";
}
