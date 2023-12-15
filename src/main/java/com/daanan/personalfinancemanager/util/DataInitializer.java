package com.daanan.personalfinancemanager.util;

import com.daanan.personalfinancemanager.model.Category;
import com.daanan.personalfinancemanager.model.User;
import com.daanan.personalfinancemanager.repository.CategoryRepository;
import com.daanan.personalfinancemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Ensure there is a default user in the database
        User defaultUser = userRepository.findByUsername("defaultUser").orElseGet(() -> {
            User newUser = new User(
                    "defaultUser",
                    "default@example.com",
                    passwordEncoder.encode("password"),  // Encode the password here
                    "Default User",
                    true
            );
            return userRepository.save(newUser);
        });

        // Check if categories already exist to avoid duplicates
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(defaultUser, "Groceries", CategoryType.EXPENSE));
            categoryRepository.save(new Category(defaultUser, "Salary", CategoryType.INCOME));
            categoryRepository.save(new Category(defaultUser, "Utilities", CategoryType.EXPENSE));
            categoryRepository.save(new Category(defaultUser, "Entertainment", CategoryType.EXPENSE));
        }
    }
}

