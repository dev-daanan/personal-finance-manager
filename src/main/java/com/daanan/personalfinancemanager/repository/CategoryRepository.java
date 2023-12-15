package com.daanan.personalfinancemanager.repository;

import com.daanan.personalfinancemanager.model.Category;
import com.daanan.personalfinancemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUser(User user);
    // Additional custom methods if needed
}
