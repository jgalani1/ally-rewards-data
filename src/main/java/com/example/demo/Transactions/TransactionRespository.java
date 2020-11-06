package com.example.demo.Transactions;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRespository extends JpaRepository<TransactionData, UUID> {

}
