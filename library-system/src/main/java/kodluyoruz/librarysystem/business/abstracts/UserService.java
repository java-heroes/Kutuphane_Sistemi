package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

public interface UserService {
    User save(UserDto user);

    List<User> findAll();

    User findOne(String username);
    
    Result update(UserDto user); 
    
    Result delete(UserDto user);
}
