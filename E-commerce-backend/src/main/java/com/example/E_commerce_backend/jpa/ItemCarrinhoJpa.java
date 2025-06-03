package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.ItemCarrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoJpa extends JpaRepository<ItemCarrinhoModel, Integer> {
}
