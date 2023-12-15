package com.daanan.personalfinancemanager.repository;

import com.daanan.personalfinancemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
