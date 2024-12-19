package com.scalerecom.scalerecom.repository;

import com.scalerecom.scalerecom.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCatTitle(String catTitle);
}
