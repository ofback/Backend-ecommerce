package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.FavoritoModel;
import com.example.E_commerce_backend.Repositories.FavoritoRepository;
import com.example.E_commerce_backend.jpa.FavoritoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoritoImplementation implements FavoritoRepository {

    private final FavoritoJpa favoritoJpa;

    @Autowired
    public FavoritoImplementation(FavoritoJpa favoritoJpa) {
        this.favoritoJpa = favoritoJpa;
    }

    @Override
    public FavoritoModel searchByCode(int id) {
        return favoritoJpa.findById(id).orElse(null);
    }

    @Override
    public List<FavoritoModel> buscar() {
        return favoritoJpa.findAll();
    }

    @Override
    public void addFavorito(FavoritoModel favoritoModel) {
        favoritoJpa.save(favoritoModel);
    }

    @Override
    public void removeFavorito(int id) {
        favoritoJpa.deleteById(id);
    }

    @Override
    public void updateFavorito(int id, FavoritoModel favoritoModel) {
        FavoritoModel favoritoExistente = favoritoJpa.findById(id).orElse(null);
        if (favoritoExistente != null) {
            favoritoExistente.setUsuario(favoritoModel.getUsuario());
            favoritoExistente.setProduto(favoritoModel.getProduto());

            favoritoJpa.save(favoritoExistente);
        }
    }

    @Override
    public boolean estaVazio() {
        return favoritoJpa.count() == 0;
    }
}
