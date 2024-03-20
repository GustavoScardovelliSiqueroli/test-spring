package com.testapi.first.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testapi.first.models.Shirt;
import java.util.UUID;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, UUID> {
    
}
