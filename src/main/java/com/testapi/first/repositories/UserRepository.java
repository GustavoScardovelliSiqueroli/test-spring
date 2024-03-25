package com.testapi.first.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testapi.first.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}