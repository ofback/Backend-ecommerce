package com.example.E_commerce_backend.models.Repositories;

import com.example.E_commerce_backend.models.Entities.AdminModel;

import java.util.List;

public interface AdminRepository {
    public AdminModel searchByCode(int code);
    public List<AdminModel> buscar();
    public void addAdmin(AdminModel timesModel);
    public void removeAdmin(int code);
    public void updateAdmin(int code, AdminModel timesModel);
    public boolean estaVazio();
}
