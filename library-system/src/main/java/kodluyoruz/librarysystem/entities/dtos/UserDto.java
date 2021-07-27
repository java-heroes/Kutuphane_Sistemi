package kodluyoruz.librarysystem.entities.dtos;

import kodluyoruz.librarysystem.entities.concretes.User;
import lombok.Data;

@Data
public class UserDto {
    
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    


    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setName(name);
        
        return user;
    }
}
