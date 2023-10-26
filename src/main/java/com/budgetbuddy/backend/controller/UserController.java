package com.budgetbuddy.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budgetbuddy.backend.model.User;
import com.budgetbuddy.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody User user) {
        User newUser = userService.signUp(user);
        return new ResponseEntity<>(newUser != null, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<Boolean> signIn(@RequestBody User user) {
        User signedInUser = userService.signIn(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(signedInUser != null, HttpStatus.OK);
    }

    @PostMapping("/signout")
    public ResponseEntity<Boolean> signOut(@RequestParam Long userId) {
        userService.signOut(userId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/updateUserPermission")
    public ResponseEntity<Boolean> updateUserPermission(@RequestParam Long userId, @RequestParam Boolean permission) {
        userService.updateUserPermission(userId, permission);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getUserPermission")
    public ResponseEntity<Boolean> getUserPermission(@RequestParam Long userId) {
        Boolean permission = userService.getUserPermission(userId);
        return new ResponseEntity<>(permission, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
