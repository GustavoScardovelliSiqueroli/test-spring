package com.testapi.first.repositories;

import org.springframework.stereotype.Repository;

import com.testapi.first.entities.Shirt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, UUID> {
    
}
