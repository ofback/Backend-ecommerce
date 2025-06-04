package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.CategoriaModel;

import java.util.List;

public interface CategoriaRepository {
    List<CategoriaModel> buscar();
    CategoriaModel searchByCode(int id);
    void addCategoria(CategoriaModel categoriaModel);
    void updateCategoria(int id, CategoriaModel categoriaModel);
    void removeCategoria(int id);
    boolean estaVazio();
}
