package uz.g22.repository.user;



import uz.g22.entity.user.User;
import uz.g22.entity.user.UserRole;
import uz.g22.repository.BaseRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User> {


    User getByEmail(String email);
    void updateRole(UserRole role, UUID id);
    String GET_BY_USERNAME = "select u from users u where email = :email";

    String GET_ALL_USERS = "select u from users u ";

    List<User> getAllUsers();

}
