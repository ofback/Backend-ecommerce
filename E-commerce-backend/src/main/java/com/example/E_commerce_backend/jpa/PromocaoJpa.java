package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.PromocaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoJpa extends JpaRepository<PromocaoModel, Integer> {

}
