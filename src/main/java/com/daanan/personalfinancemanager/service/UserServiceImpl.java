package com.daanan.personalfinancemanager.service;

import com.daanan.personalfinancemanager.dto.UserDto;
import com.daanan.personalfinancemanager.model.User;
import com.daanan.personalfinancemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    /* TODO: A few points to note:
        Validation: As you mentioned, adding validation in the service methods is a good practice.
        Exception Handling: Consider more specific exception handling rather than a generic RuntimeException.
            For example, you might want to throw a UserNotFoundException for better clarity.
    */

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired


    @Override
    public List<User> findAll( ) {

        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {

        Optional<User> theUser = userRepository.findById(theId);
        if (theUser.isPresent()) {
            return theUser.get();
        } else {
            throw new RuntimeException("Invalid Id to find.");
        }
    }

    @Override
    public User save(User theUser) {

        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {

        userRepository.deleteById(theId);
    }

    @Override
    public User registerNewUser(UserDto userDto) {
        // Check if user already exists
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalStateException("Username already taken");
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPasswordHash(passwordEncoder.encode(userDto.getPassword())); // Encode the password
        newUser.setName(userDto.getName());

        return userRepository.save(newUser); // Save the new user to the database
    }

    @Override
    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

}
