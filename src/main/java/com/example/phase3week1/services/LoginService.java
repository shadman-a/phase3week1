package com.example.phase3week1.services;

import com.example.phase3week1.models.User;
import com.example.phase3week1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public boolean loginUser(User user) {

        Iterable<User> allUsers = userRepository.findAll();

        for (User userEntity : allUsers) {
            if (userEntity.getName().equals(user.getName()) && userEntity.getPassword().equals(user.getPassword())) {
                if (duplicateUser(user)) {
                    userRepository.save(user);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private boolean duplicateUser(User user) {
        Iterable<User> allUsers = userRepository.findAll();

        for (User userEntity : allUsers) {
            if(userEntity.getName().equals(user.getName())) {
                return false;
            }
        }
        return true;
    }
}
