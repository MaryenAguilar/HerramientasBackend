package com.marly.demo.Domain.Repository;

import com.marly.demo.Domain.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getActiveCategories();
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(int id);
    Category save(Category category);
    void delete(int id);
}