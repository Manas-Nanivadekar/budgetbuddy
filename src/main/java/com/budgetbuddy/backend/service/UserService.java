package com.budgetbuddy.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetbuddy.backend.model.User;
import com.budgetbuddy.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(User user) {
        // save user and return generated id
        user.setSignedIn(true);
        userRepository.save(user);
        return user.getId() != null ? user : null;
    }

    public User signIn(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setSignedIn(true);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public void signOut(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setSignedIn(false);
            userRepository.save(user);
        }
    }

    public void updateUserPermission(Long userId, Boolean permission) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setUserMessagePermission(permission);
            userRepository.save(user);
        }
    }

    public Boolean getUserPermission(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? user.getUserMessagePermission() : null;
    }

    // Return all the users in the database
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
