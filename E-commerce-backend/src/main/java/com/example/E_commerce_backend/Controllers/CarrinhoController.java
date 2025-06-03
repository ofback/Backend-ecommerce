package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.CarrinhoModel;
import com.example.E_commerce_backend.Usecases.CarrinhoUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoUsecase carrinhoUsecase;

    @Autowired
    public CarrinhoController(CarrinhoUsecase carrinhoUsecase) {
        this.carrinhoUsecase = carrinhoUsecase;
    }

    @GetMapping
    public List<CarrinhoModel> listarTodos() {
        return carrinhoUsecase.obterTodosCarrinhos();
    }

    @GetMapping("/{id}")
    public CarrinhoModel buscarPorId(@PathVariable int id) {
        return carrinhoUsecase.obterCarrinhoPorId(id);
    }

    @PostMapping
    public void criarCarrinho(@RequestBody CarrinhoModel carrinhoModel) {
        carrinhoUsecase.criarCarrinho(carrinhoModel);
    }

    @PutMapping("/{id}")
    public void atualizarCarrinho(@PathVariable int id, @RequestBody CarrinhoModel carrinhoModel) {
        carrinhoUsecase.updateCarrinho(id, carrinhoModel);
    }

    @DeleteMapping("/{id}")
    public void removerCarrinho(@PathVariable int id) {
        carrinhoUsecase.removeCarrinho(id);
    }
} 