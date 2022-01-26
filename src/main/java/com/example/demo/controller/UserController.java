package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public Optional<User> getUserByUserName(@PathVariable("userName")String userName){
           return Optional.ofNullable(userService.getUserByUserName(userName));
    }

    @PostMapping
    public void addUser( @RequestBody User user){
        userService.addUser(user);
    }

}
