package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.FavoritoModel;

import java.util.List;

public interface FavoritoRepository {
    public FavoritoModel searchByCode(int id);
    public List<FavoritoModel> buscar();
    public void addFavorito(FavoritoModel favorito);
    public void removeFavorito(int id);
    void updateFavorito(int id, FavoritoModel favoritoModel);
    public boolean estaVazio();
}
