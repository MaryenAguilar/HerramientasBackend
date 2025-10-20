package com.marly.demo.Persistance;

import com.marly.demo.Domain.Repository.RoleRepository;
import com.marly.demo.Domain.Role;
import com.marly.demo.Persistance.Crud.RolCrudRepository;
import com.marly.demo.Persistance.Mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class RolRepository implements RoleRepository  {
    @Autowired
    private RolCrudRepository rolCrudRepository;

    @Autowired
    private RoleMapper mapper;

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return rolCrudRepository.findByNombre(roleName)
                .map(rol -> mapper.toRole(rol));
    }
}
