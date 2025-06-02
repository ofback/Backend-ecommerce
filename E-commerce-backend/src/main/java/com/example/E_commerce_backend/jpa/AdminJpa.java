package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpa extends JpaRepository<AdminModel, Integer> {

}
