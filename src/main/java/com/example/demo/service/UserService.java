package com.example.demo.service;


import com.example.demo.Exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List <User>getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByUserName(String userName){
        return userRepository.findUserByUserName(userName).get();
    }

    public void addUser(User user) {
        Boolean existsUserName = userRepository
                .selectExistsUserName(user.getUserName());
        Boolean existsEmail = userRepository
                .selectExistsEmail(user.getEmail());
        if (existsUserName){
            throw new BadRequestException(
                    "Användarnamnet " + user.getUserName() + " är upptaget");
        }
        if (existsEmail){
            throw new BadRequestException(
                    "Email " + user.getEmail() + " är upptaget");
        }
        userRepository.save(user);
    }


}
