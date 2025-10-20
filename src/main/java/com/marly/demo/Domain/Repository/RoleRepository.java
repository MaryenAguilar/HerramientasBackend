package com.marly.demo.Domain.Repository;

import com.marly.demo.Domain.Role;
import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByRoleName(String nombre);
}
