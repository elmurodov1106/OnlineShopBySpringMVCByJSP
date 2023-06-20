package uz.g22.service.product;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.product.Product;
import uz.g22.entity.product.ProductCategory;
import uz.g22.entity.user.User;
import uz.g22.repository.product.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public int add(ProductCreateDto product, UUID id) {
        Product product1 = modelMapper.map(product, Product.class);
        ProductCategory map = modelMapper.map(product.getCategory(), ProductCategory.class);

        User userEntity = new User();
        userEntity.setId(id);
        product1.setUser(userEntity);
        product1.setCategory(map);
        productRepository.save(product1);
        return 1;
    }

    @Override
    public List<Product> getUserProducts(UUID ownerId) {
        return productRepository.getUserProduct(ownerId);
    }

    @Override
    public void deleteById(UUID id) {
      productRepository.deleteById(id);
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.getById(id);
    }

    @Override
    @Transactional
    public void update(ProductCreateDto update, UUID id, UUID userId) {
        Product product = productRepository.getById(id);
        if (product.getUser().getId().equals(userId)) {
            modelMapper.getConfiguration()
                    .setPropertyCondition(Objects::nonNull)
                    .setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(update, product);
            productRepository.update(product);
        }
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.allProducts();
    }
}
