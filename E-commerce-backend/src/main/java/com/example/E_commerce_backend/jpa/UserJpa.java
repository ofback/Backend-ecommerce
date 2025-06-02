package com.example.E_commerce_backend.jpa;

import com.example.E_commerce_backend.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<UserModel, Integer> {

}
