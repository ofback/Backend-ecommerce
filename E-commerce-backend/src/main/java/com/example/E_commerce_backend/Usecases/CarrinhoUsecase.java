package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.CarrinhoModel;
import com.example.E_commerce_backend.Repositories.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoUsecase {
    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoUsecase(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public List<CarrinhoModel> obterTodosCarrinhos() {
        return carrinhoRepository.buscar();
    }

    public CarrinhoModel obterCarrinhoPorId(int id) {
        return carrinhoRepository.searchByCode(id);
    }

    public void criarCarrinho(CarrinhoModel carrinhoModel) {
        carrinhoRepository.addCarrinho(carrinhoModel);
    }

    public void updateCarrinho(int id, CarrinhoModel carrinhoModel) {
        carrinhoRepository.updateCarrinho(id, carrinhoModel);
    }

    public void removeCarrinho(int id) {
        carrinhoRepository.removeCarrinho(id);
    }
} 