package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.Role;
import com.marly.demo.Persistance.Entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source = "idRol", target = "idRole"),
            @Mapping(source = "nombre", target = "name")
    })
    Role toRole(Rol rol);

    @InheritInverseConfiguration
    Rol toRol(Role role);
}
