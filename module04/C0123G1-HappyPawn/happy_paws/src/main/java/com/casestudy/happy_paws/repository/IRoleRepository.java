package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
