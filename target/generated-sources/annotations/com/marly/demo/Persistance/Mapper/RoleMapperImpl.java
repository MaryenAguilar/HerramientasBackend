package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.Role;
import com.marly.demo.Persistance.Entity.Rol;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-22T18:56:36-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toRole(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        Role role = new Role();

        role.setIdRole( rol.getIdRol() );
        role.setName( rol.getNombre() );

        return role;
    }

    @Override
    public Rol toRol(Role role) {
        if ( role == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setIdRol( role.getIdRole() );
        rol.setNombre( role.getName() );

        return rol;
    }
}
