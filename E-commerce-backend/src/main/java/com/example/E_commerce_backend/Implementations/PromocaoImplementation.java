package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.jpa.PromocaoJpa;
import com.example.E_commerce_backend.Models.PromocaoModel;

import java.util.List;

public class PromocaoImplementation {
    private final PromocaoJpa promocaoJpa;

    public PromocaoImplementation(PromocaoJpa promocaoJpa) {
        this.promocaoJpa = promocaoJpa;
    }

    public List<PromocaoModel> buscar() {
        return promocaoJpa.findAll();
    }

    public PromocaoModel searchByCode(int id) {
        return promocaoJpa.findById(id).orElse(null);
    }

    public void addPromocao(PromocaoModel promocaoModel) {
        promocaoJpa.save(promocaoModel);
    }
    
    public void updatePromocao(int id, PromocaoModel promocaoModel) {
        PromocaoModel promocaoInDb = promocaoJpa.findById(id).orElse(null);
        if (promocaoInDb != null) {
            promocaoInDb.setPrecoReal(promocaoModel.getPrecoReal());
            promocaoInDb.setPrecoPromocional(promocaoModel.getPrecoPromocional());
            promocaoJpa.save(promocaoInDb);
        }
    }

    public void removePromocao(int id) {
        promocaoJpa.deleteById(id);
    }
    
    public boolean estaVazio() {
        return promocaoJpa.findAll().isEmpty();
    }
    
}
