package kodluyoruz.librarysystem.business.concretes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.stereotype.Service;

import kodluyoruz.librarysystem.business.abstracts.RoleService;
import kodluyoruz.librarysystem.business.abstracts.UserService;

import kodluyoruz.librarysystem.core.utilities.Results.DataResult;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessDataResult;
import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessResult;
import kodluyoruz.librarysystem.dataAccess.abstracts.UserDao;
import kodluyoruz.librarysystem.entities.concretes.Role;
import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service(value = "userService")
public class UserManager implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public DataResult<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return new SuccessDataResult<>(list);
    }

    @Override
    public DataResult<User> findOne(String username) {
        return new SuccessDataResult<User>(userDao.findByUsername(username));
    }

    @Override
    public DataResult<User> save(UserDto user) {

        User nUser = user.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if (nUser.getEmail().split("@")[1].equals("admin.edu")) {
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return new SuccessDataResult<User>(userDao.save(nUser));
    }

	@Override
	public Result update(UserDto user) {
		
		/*User dtoUser =new User();
		dtoUser.setId(user.getId());
		dtoUser.setUsername(user.getUsername());
		dtoUser.setEmail(user.getEmail());
		dtoUser.setName(user.getName());
		dtoUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		dtoUser.setPhone(user.getPhone());
		this.userDao.save(dtoUser);
		
		return new SuccessResult("Kullanıcı başarıyla güncellendi");*/
		
		   User nUser = user.getUserFromDto();
	        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

	        Role role = roleService.findByName("USER");
	        Set<Role> roleSet = new HashSet<>();
	        roleSet.add(role);

	        if (nUser.getEmail().split("@")[1].equals("admin.edu")) {
	            role = roleService.findByName("ADMIN");
	            roleSet.add(role);
	        }

	        nUser.setRoles(roleSet);
	        return new SuccessDataResult<User>(userDao.save(nUser));
	}

	@Override
	public Result delete(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}
}