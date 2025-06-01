package com.example.E_commerce_backend.models.Jpa;

import com.example.E_commerce_backend.models.Entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<UserModel, Integer> {

}
