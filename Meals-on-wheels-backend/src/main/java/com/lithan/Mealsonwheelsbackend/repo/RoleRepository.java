package com.lithan.Mealsonwheelsbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
