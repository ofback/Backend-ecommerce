package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.ProdutoModel;

import java.util.List;

public interface ProdutoRepository {
    public ProdutoModel searchByCode(int id);
    public List<ProdutoModel> buscar();
    void removeProduto(int id);
    void addProduto(ProdutoModel produtoModel);
    void updateProduto(int id, ProdutoModel produtoModel);
    boolean estaVazio();
}

