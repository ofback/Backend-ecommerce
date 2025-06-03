package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpa extends JpaRepository<ProdutoModel, Integer> {

}
