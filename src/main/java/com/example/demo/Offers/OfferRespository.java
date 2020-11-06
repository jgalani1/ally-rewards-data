package com.example.demo.Offers;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRespository extends JpaRepository<OfferData, UUID> {
    
}
