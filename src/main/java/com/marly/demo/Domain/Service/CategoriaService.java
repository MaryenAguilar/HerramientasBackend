package com.marly.demo.Domain.Service;


import com.marly.demo.Domain.Category;
import com.marly.demo.Persistance.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

   
    public List<Category> getCategoriasActivas() {
        return categoriaRepository.getActiveCategories();
    }

    
    public List<Category> getAllCategories() {
        return categoriaRepository.getAllCategories();
    }

    
    public Optional<Category> getCategoryById(int id) {
        return categoriaRepository.getCategoryById(id);
    }

   
    public Category saveCategory(Category category) {
        return categoriaRepository.save(category);
    }

    
    public void deleteCategory(int id) {
        categoriaRepository.delete(id);
    }
}