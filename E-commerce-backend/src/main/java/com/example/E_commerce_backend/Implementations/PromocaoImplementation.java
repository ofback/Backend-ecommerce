package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.jpa.PromocaoJpa;
import com.example.E_commerce_backend.Models.PromocaoModel;
import com.example.E_commerce_backend.Repositories.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromocaoImplementation implements PromocaoRepository {
    private final PromocaoJpa promocaoJpa;

    @Autowired
    public PromocaoImplementation(PromocaoJpa promocaoJpa) {
        this.promocaoJpa = promocaoJpa;
    }

    @Override
    public List<PromocaoModel> buscar() {
        return promocaoJpa.findAll();
    }

    @Override
    public PromocaoModel searchByCode(int id) {
        return promocaoJpa.findById(id).orElse(null);
    }

    @Override
    public void addPromocao(PromocaoModel promocaoModel) {
        promocaoJpa.save(promocaoModel);
    }

    @Override
    public void updatePromocao(int id, PromocaoModel promocaoModel) {
        PromocaoModel promocaoInDb = promocaoJpa.findById(id).orElse(null);
        if (promocaoInDb != null) {
            promocaoInDb.setPrecoReal(promocaoModel.getPrecoReal());
            promocaoInDb.setPrecoPromocional(promocaoModel.getPrecoPromocional());

            promocaoJpa.save(promocaoInDb);
        }
    }

    @Override
    public void removePromocao(int id) {
        promocaoJpa.deleteById(id);
    }

    @Override
    public boolean estaVazio() {
        return promocaoJpa.count() == 0;
    }
}