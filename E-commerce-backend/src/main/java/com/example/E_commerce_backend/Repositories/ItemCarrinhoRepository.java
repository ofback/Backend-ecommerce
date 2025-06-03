package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.ItemCarrinhoModel;

import java.util.List;

public interface ItemCarrinhoRepository {
    List<ItemCarrinhoModel> buscar();
    ItemCarrinhoModel searchByCode(int id);
    void addItem(ItemCarrinhoModel itemCarrinhoModel);
    void updateItem(int id, ItemCarrinhoModel itemCarrinhoModel);
    void removeItem(int id);
    boolean estaVazio();
}
