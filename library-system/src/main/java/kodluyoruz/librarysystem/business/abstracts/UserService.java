package kodluyoruz.librarysystem.business.abstracts;

import java.util.List;

<<<<<<< HEAD
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
=======
import kodluyoruz.librarysystem.core.utilities.Results.Result;
>>>>>>> 0c5ff147c80b8dab99d581804345fd061ac9f261
import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

public interface UserService {
    DataResult<User> save(UserDto user);

    DataResult<List<User>> findAll();

<<<<<<< HEAD
    DataResult<User> findOne(String username);
=======
    User findOne(String username);
    
    Result update(UserDto user); 
    
    Result delete(UserDto user);
>>>>>>> 0c5ff147c80b8dab99d581804345fd061ac9f261
}
