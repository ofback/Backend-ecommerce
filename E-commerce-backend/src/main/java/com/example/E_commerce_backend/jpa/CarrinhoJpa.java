package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.CarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoJpa extends JpaRepository<CarrinhoModel, Integer> {

}
