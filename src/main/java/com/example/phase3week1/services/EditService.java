package com.example.phase3week1.services;

import com.example.phase3week1.models.User;
import com.example.phase3week1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    @Autowired
    UserRepository userRepository;

    public boolean editUser(User user) {
        if(duplicateUser(user)) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
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
