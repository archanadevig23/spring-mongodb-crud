package com.quinbay.springmongocrud.controller;

import com.quinbay.springmongocrud.model.User;
import com.quinbay.springmongocrud.repository.UserRepository;
import com.quinbay.springmongocrud.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    //CRUD

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @GetMapping("/viewUsers")
    public List<User> viewUsers() {
        return userServiceImpl.getAllUsers();
    }

    @PutMapping("/updateName")
    public String updateUserName(@RequestParam Integer id, @RequestParam String name) {
        return userServiceImpl.updateName(id, name);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(User user) {
        return userServiceImpl.deleteUser(user);
    }
}
