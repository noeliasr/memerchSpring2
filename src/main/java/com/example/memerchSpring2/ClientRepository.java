package com.example.memerchSpring2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    
    List<ClientEntity> findByNameContainsIgnoreCase(String name);

    List<ClientEntity> findBySurnameContainsIgnoreCase(String surname);

    List<ClientEntity> findByNameContainsOrSurnameContainsAllIgnoreCase(String name,
    String surname);
    
}    