package com.daanan.personalfinancemanager.service;

import com.daanan.personalfinancemanager.dto.UserDto;
import com.daanan.personalfinancemanager.model.User;

import java.util.List;

public interface UserService {

    // Find all
    List<User> findAll();

    // Find by ID
    User findById(int theId);

    // Save
    User save(User theUser);

    // Delete
    void deleteById(int theId);

    User registerNewUser(UserDto userDto);

    User findByUsername(String username);
}
