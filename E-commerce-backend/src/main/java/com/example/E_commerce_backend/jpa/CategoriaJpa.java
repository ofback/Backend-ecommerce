package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpa extends JpaRepository<CategoriaModel, Integer> {

}