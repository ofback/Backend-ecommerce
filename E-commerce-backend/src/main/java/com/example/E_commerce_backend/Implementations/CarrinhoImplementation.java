package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.CarrinhoModel;
import com.example.E_commerce_backend.Repositories.CarrinhoRepository;
import com.example.E_commerce_backend.jpa.CarrinhoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarrinhoImplementation implements CarrinhoRepository {

    private final CarrinhoJpa carrinhoJpa;

    @Autowired
    public CarrinhoImplementation(CarrinhoJpa carrinhoJpa) {
        this.carrinhoJpa = carrinhoJpa;
    }

    @Override
    public List<CarrinhoModel> buscar() {
        return carrinhoJpa.findAll();
    }

    @Override
    public CarrinhoModel searchByCode(int id) {
        return carrinhoJpa.findById(id).orElse(null);
    }

    @Override
    public void addCarrinho(CarrinhoModel carrinhoModel) {
        carrinhoJpa.save(carrinhoModel);
    }

    @Override
    public void updateCarrinho(int id, CarrinhoModel carrinhoModel) {
        CarrinhoModel carrinhoInDb = carrinhoJpa.findById(id).orElse(null);
        if (carrinhoInDb != null) {
            carrinhoInDb.setUsuarioId(carrinhoModel.getUsuarioId());
            carrinhoInDb.setItens(carrinhoModel.getItens());
            carrinhoInDb.setAtualizadoEm(carrinhoModel.getAtualizadoEm());

            carrinhoJpa.save(carrinhoInDb);
        }
    }

    @Override
    public void removeCarrinho(int id) {
        carrinhoJpa.deleteById(id);
    }

    @Override
    public boolean estaVazio() {
        return carrinhoJpa.count() == 0;
    }
}
