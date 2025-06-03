package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.CarrinhoModel;

import java.util.List;

public interface CarrinhoRepository {
    List<CarrinhoModel> buscar();
    CarrinhoModel searchByCode(int id);
    void addCarrinho(CarrinhoModel carrinhoModel);
    void updateCarrinho(int id, CarrinhoModel carrinhoModel);
    void removeCarrinho(int id);
    boolean estaVazio();
}
