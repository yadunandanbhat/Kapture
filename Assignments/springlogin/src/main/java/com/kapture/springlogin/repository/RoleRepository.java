package com.kapture.springlogin.repository;

import com.kapture.springlogin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
