package com.example.demo.Deals;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRespository extends JpaRepository<DealData, UUID> {
    
}
