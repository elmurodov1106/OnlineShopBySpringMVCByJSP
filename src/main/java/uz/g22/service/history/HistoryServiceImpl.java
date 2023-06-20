package uz.g22.service.history;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.dto.OrderCreateDto;
import uz.g22.dto.ProductCreateDto;
import uz.g22.entity.history.History;
import uz.g22.entity.order.OrderEntity;
import uz.g22.entity.product.Product;
import uz.g22.entity.product.ProductCategory;
import uz.g22.entity.user.User;
import uz.g22.repository.history.HistoryRepository;
import uz.g22.repository.product.ProductRepository;
import uz.g22.repository.user.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService{

    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public int add(ProductCreateDto productCreateDto,UUID id, UUID owner_id) {

        History history = modelMapper.map(productCreateDto, History.class );
//        ProductCategory map = modelMapper.map(history.getProduct_category(), ProductCategory.class);
        //  List<History> userHistories = historyRepository.getUserHistories(owner_id);

        User user = new User();
        user.setId(owner_id);
        history.setUsers(user);
        history.setProduct_name(productCreateDto.getName());
        history.setProduct_amount(productCreateDto.getAmount());
        history.setProduct_price(productCreateDto.getPrice());
        history.setProduct_category(ProductCategory.valueOf(productCreateDto.getCategory()));
        history.setProduct_description(productCreateDto.getDescription());

//        Product product = productRepository.getById(id);
        //history.setUsers(user);
       // history.setProduct_category(map);
//        history.set(user.getName());
//        history.setProduct_description(product.getDescription());
//        history.setProduct_amount(product.getAmount());
//        history.setProduct_name(product.getName());
//        history.setProduct_price(product.getPrice());
//        history.setUsers(product.getUser());
        historyRepository.save(history);
        return 1;
    }


    @Override
    public List<History> getUserHistories(UUID ownerId) {
        return historyRepository.getUserHistories(ownerId);
    }

    @Override
    public History getById(UUID id) {
        return historyRepository.getById(id);
    }

    @Override
    public void deleteById(UUID id) {
      historyRepository.deleteById(id);
    }

    @Override
    public List<History> getAllHistories() {
        return historyRepository.allHistories();
    }
}
