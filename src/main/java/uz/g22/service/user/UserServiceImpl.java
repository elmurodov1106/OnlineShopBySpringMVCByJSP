package uz.g22.service.user;

import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.repository.user.UserRepository;
import uz.g22.repository.user.UserRepositoryImpl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepositoryImpl;
    @Override
    public User signIn(String email, String password) {
        try {
User byEmail = userRepositoryImpl.getByEmail(email);
            if (Objects.equals(byEmail.getPassword(),password)){
                return byEmail;
            }
        }catch (NoResultException ignored){
        }
        return null;
}

    @Override
    public int add(User user) {
       try {
           userRepositoryImpl.save(user);
       }catch (DataIntegrityViolationException e){
           return 400;
       }
        return 200;

    }


    @Override
    public User getById(UUID id) {
        return userRepositoryImpl.getById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(UUID id) {
        userRepositoryImpl.deleteById(id);
        return true;
    }

    @Override
    public User update(User user) {

        return userRepositoryImpl.update(user);
    }

    @Override
    @Transactional
    public boolean updateRole(UserRole userRole,UUID userId) {
         userRepositoryImpl.updateRole(userRole,userId);
         return true;

    }

    @Override
    public List<User> allUser() {
        return userRepositoryImpl.getAllUsers();
    }
}
