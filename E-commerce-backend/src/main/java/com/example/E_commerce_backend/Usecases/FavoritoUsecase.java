package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.FavoritoModel;
import com.example.E_commerce_backend.Repositories.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoUsecase {

    private final FavoritoRepository favoritoRepository;

    public FavoritoUsecase(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public List<FavoritoModel> buscar() {
        return favoritoRepository.buscar();
    }

    public FavoritoModel searchByCode(int id) {
        return favoritoRepository.searchByCode(id);
    }

    public void addFavorito(FavoritoModel favoritoModel) {
        favoritoRepository.addFavorito(favoritoModel);
    }

    public void removeFavorito(int id) {
        favoritoRepository.removeFavorito(id);
    }

    public void updateFavorito(int id, FavoritoModel favoritoModel) {
        favoritoRepository.updateFavorito(id, favoritoModel);
    }

    public boolean estaVazio() {
        return favoritoRepository.estaVazio();
    }
}
