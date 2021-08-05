package kodluyoruz.librarysystem.api.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import kodluyoruz.librarysystem.business.abstracts.UserService;
import kodluyoruz.librarysystem.config.TokenProvider;
import kodluyoruz.librarysystem.core.utilities.Results.DataResult;

import kodluyoruz.librarysystem.core.utilities.Results.ErrorDataResult;

import kodluyoruz.librarysystem.core.utilities.Results.Result;
import kodluyoruz.librarysystem.core.utilities.Results.SuccessDataResult;
import kodluyoruz.librarysystem.entities.concretes.Book;

import kodluyoruz.librarysystem.entities.concretes.User;
import kodluyoruz.librarysystem.entities.dtos.AuthToken;
import kodluyoruz.librarysystem.entities.dtos.LoginUser;
import kodluyoruz.librarysystem.entities.dtos.UserDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public DataResult<User> saveUser(@Valid @RequestBody UserDto user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UserDto user) {
        return this.userService.update(user);
    }
    
    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
    	return this.userService.findAll();
    }
    

}
