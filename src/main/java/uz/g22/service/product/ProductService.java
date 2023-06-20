package uz.g22.service.product;

import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.product.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    int add(ProductCreateDto product, UUID id);

    List<Product> getUserProducts(UUID ownerId);

    void deleteById(UUID id);
    Product getById(UUID id);

    void update(ProductCreateDto update,UUID id,UUID userId);
    List<Product> getAllProducts();
}
