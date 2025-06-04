package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.AdminModel;

import java.util.List;

public interface AdminRepository {
    public AdminModel searchByCode(int code);
    public List<AdminModel> buscar();
    public void addAdmin(AdminModel adminModel);
    public void removeAdmin(int code);
    public void updateAdmin(int code, AdminModel adminModel);
    public boolean estaVazio();
}
