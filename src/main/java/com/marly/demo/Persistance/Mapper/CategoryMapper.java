package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.Category;

import com.marly.demo.Persistance.Entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    List<Category> toCategories(List<Categoria> categorias);

    @Mappings({
        @Mapping(source = "categoryId", target = "idCategoria"),
        @Mapping(source = "category", target = "descripcion"),
        @Mapping(source = "active", target = "estado"),
        @Mapping(target = "productos", ignore = true)
    })
    Categoria toCategoria(Category category);
}