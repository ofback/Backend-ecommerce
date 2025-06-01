package com.example.E_commerce_backend.models.Jpa;

import com.example.E_commerce_backend.models.Entities.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpa extends JpaRepository<AdminModel, Integer> {

}
