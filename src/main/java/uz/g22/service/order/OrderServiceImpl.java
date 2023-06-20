package uz.g22.service.order;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.dto.OrderCreateDto;
import uz.g22.entity.order.OrderEntity;
import uz.g22.entity.order.OrderStatus;
import uz.g22.entity.product.Product;
import uz.g22.entity.product.ProductCategory;
import uz.g22.entity.user.User;
import uz.g22.repository.order.OrderRepository;
import uz.g22.repository.product.ProductRepository;
import uz.g22.repository.user.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.hibernate.Hibernate.map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

//    @Override
//    public int add(OrderEntity order, UUID id) {
//        Product product1 = modelMapper.map(product, Product.class);
//        ProductCategory map = modelMapper.map(product.getCategory(), ProductCategory.class);
//
//        User userEntity = new User();
//        userEntity.setId(id);
//        product1.setUser(userEntity);
//        product1.setCategory(map);
//        productRepository.save(product1);
//        return 1;
//        Order order1 = modelMapper.map(order, Order.class);

//        User userEntity = new User();
//        userEntity.setId(id);
//        orderRepository.save(order);
//        return 1;
//    }


    @Override
    @Transactional
    public int add(OrderCreateDto order, UUID owner_id, UUID product_id) {

        OrderEntity map = modelMapper.map(order, OrderEntity.class);

        Product product = productRepository.getById(product_id);
        User user = userRepository.getById(owner_id);
        // OrderEntity order1 = new OrderEntity();
        map.setUser(user);
        map.setProduct(product);
        map.setStatus(OrderStatus.DONE);
//        order1.setProduct(product);
//        order1.setAmount(map.getAmount());
//        order1.setUser(user);
        orderRepository.save(map);
        return 1;
    }


    @Override
    public List<OrderEntity> getUserOrders(UUID ownerId) {
        return orderRepository.getUserOrders(ownerId);
    }

    @Override
    public void deleteById(UUID id) {
        orderRepository.deleteById(id);

    }

    @Override
    public OrderEntity getById(UUID id) {
        return orderRepository.getById(id);
    }

    @Override
    @Transactional
    public OrderEntity update(OrderCreateDto update, UUID id, UUID userId) {
        OrderEntity product = orderRepository.getById(id);
        if (product.getId().equals(id)) {
            modelMapper.getConfiguration()
                    .setPropertyCondition(Objects::nonNull)
                    .setPropertyCondition(Conditions.isNotNull());
               modelMapper.map(update,product);
        }
//        product.setStatus(update.getStatus());
        OrderEntity update1 = orderRepository.update(product);
        update1.setStatus(update.getStatus());
        return update1;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.allOrders();
    }
}
