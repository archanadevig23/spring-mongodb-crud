package com.quinbay.springmongocrud.serviceimpl;

import com.quinbay.springmongocrud.model.User;
import com.quinbay.springmongocrud.repository.UserRepository;
import com.quinbay.springmongocrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public String updateName(Integer id, String name) {
        userRepository.findById(id).get().setName(name);
        return "Name updated";
    }

    public List<User> getAllUsers()   {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "User added";
    }

    public String deleteUser(User user) {
        userRepository.delete(user);
        return "User deleted";
    }
}
