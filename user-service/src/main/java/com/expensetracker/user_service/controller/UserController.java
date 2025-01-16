package com.expensetracker.user_service.controller;

import com.expensetracker.user_service.model.User;
import com.expensetracker.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register new user without @Valid
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Add manual validation if needed
        return userRepository.save(user);
    }

    // Get user details by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    // Update user by id
    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }


}
