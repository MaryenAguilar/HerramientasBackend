package com.marly.demo.Persistance;

import com.marly.demo.Domain.Category;

import com.marly.demo.Domain.Repository.CategoryRepository;

import com.marly.demo.Persistance.Crud.CategoriaCrudRepository;

import com.marly.demo.Persistance.Entity.Categoria;

import com.marly.demo.Persistance.Mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getActiveCategories() {
        List<Categoria> categorias = categoriaCrudRepository.findByEstadoTrue();
        return categoryMapper.toCategories(categorias);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return categoryMapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoriaCrudRepository.findById(id).map(categoryMapper::toCategory);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        categoria = categoriaCrudRepository.save(categoria);
        return categoryMapper.toCategory(categoria);
    }

    @Override
    public void delete(int id) {
        categoriaCrudRepository.deleteById(id);
    }
}