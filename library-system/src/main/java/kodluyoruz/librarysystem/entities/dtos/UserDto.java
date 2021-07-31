package kodluyoruz.librarysystem.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodluyoruz.librarysystem.entities.concretes.User;
import lombok.Data;

@Data
public class UserDto {
    
	@NotNull
	@NotBlank
    private String username;
	@NotNull
	@NotBlank
    private String password;
	@NotNull
	@NotBlank
	@Email
    private String email;
	@NotNull
	@NotBlank
    private String phone;
	@NotNull
	@NotBlank
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
