package com.marly.demo.Persistance.Crud;

import com.marly.demo.Persistance.Entity.Categoria;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {
    List<Categoria> findByEstadoTrue();
}