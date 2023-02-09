package com.quinbay.springmongocrud.service;

import com.quinbay.springmongocrud.model.User;

import java.util.List;

public interface UserService {
    String updateName(Integer id, String name);
    List<User> getAllUsers();
    String addUser(User user);
    String deleteUser(User user);
}
