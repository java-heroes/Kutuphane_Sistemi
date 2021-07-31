package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

public interface UserService {
    DataResult<User> save(UserDto user);

    DataResult<List<User>> findAll();

    DataResult<User> findOne(String username);
}
