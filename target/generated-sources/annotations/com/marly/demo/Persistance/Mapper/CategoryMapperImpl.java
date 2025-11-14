package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.Category;
import com.marly.demo.Persistance.Entity.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T11:49:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoria.getIdCategoria() != null ) {
            category.setCategoryId( categoria.getIdCategoria() );
        }
        category.setCategory( categoria.getDescripcion() );
        if ( categoria.getEstado() != null ) {
            category.setActive( categoria.getEstado() );
        }

        return category;
    }

    @Override
    public List<Category> toCategories(List<Categoria> categorias) {
        if ( categorias == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categorias.size() );
        for ( Categoria categoria : categorias ) {
            list.add( toCategory( categoria ) );
        }

        return list;
    }

    @Override
    public Categoria toCategoria(Category category) {
        if ( category == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( category.getCategoryId() );
        categoria.setDescripcion( category.getCategory() );
        categoria.setEstado( category.isActive() );

        return categoria;
    }
}
