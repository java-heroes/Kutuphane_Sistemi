package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

public interface UserService {
    User save(UserDto user);

    List<User> findAll();

    User findOne(String username);
}
