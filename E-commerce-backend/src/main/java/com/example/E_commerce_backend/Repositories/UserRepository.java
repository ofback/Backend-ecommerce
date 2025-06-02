package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.UserModel;

import java.util.List;

public interface UserRepository {
    public UserModel searchByCode(int code);
    public List<UserModel> buscar();
    public void addUser(UserModel timesModel);
    public void removeUser(int code);
    public void updateUser(int code, UserModel userModel);
    public boolean estaVazio();
}