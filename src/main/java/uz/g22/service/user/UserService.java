package uz.g22.service.user;

import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User signIn(String email, String password);
    int add(User user);
    User getById(UUID id);
    boolean deleteById(UUID id);
    User update(User user);
    boolean updateRole(UserRole userRole,UUID userId);
    List<User> allUser();
}
