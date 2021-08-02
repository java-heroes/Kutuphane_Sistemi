package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;


import kodluyoruz.librarysystem.core.utilities.Results.DataResult;

import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

public interface UserService {
    DataResult<User> save(UserDto user);

    DataResult<List<User>> findAll();


    DataResult<User> findOne(String username);
   // User findOne(String username);
    
    Result update(UserDto user); 
    
    Result delete(UserDto user);

}
