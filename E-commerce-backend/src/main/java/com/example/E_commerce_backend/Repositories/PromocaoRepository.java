package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.PromocaoModel;

import java.util.List;

public interface PromocaoRepository {
    public PromocaoModel searchByCode(int code);
    public List<PromocaoModel> buscar();
    public void addPromocao(PromocaoModel promocaoModel);
    public void removePromocao(int code);
    public void updatePromocao(int code, PromocaoModel promocaoModel);
    public boolean estaVazio();
}