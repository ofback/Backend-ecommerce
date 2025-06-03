package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.ItemCarrinhoModel;
import com.example.E_commerce_backend.Usecases.ItemCarrinhoUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-carrinho")
public class ItemCarrinhoController {

    private final ItemCarrinhoUsecase itemCarrinhoUsecase;

    @Autowired
    public ItemCarrinhoController(ItemCarrinhoUsecase itemCarrinhoUsecase) {
        this.itemCarrinhoUsecase = itemCarrinhoUsecase;
    }

    @GetMapping
    public List<ItemCarrinhoModel> listarTodos() {
        return itemCarrinhoUsecase.obterTodosItensCarrinho();
    }

    @GetMapping("/{id}")
    public ItemCarrinhoModel buscarPorId(@PathVariable int id) {
        return itemCarrinhoUsecase.obterItemCarrinhoPorId(id);
    }

    @PostMapping
    public void criarItemCarrinho(@RequestBody ItemCarrinhoModel itemCarrinhoModel) {
        itemCarrinhoUsecase.criarItemCarrinho(itemCarrinhoModel);
    }

    @PutMapping("/{id}")
    public void atualizarItemCarrinho(@PathVariable int id, @RequestBody ItemCarrinhoModel itemCarrinhoModel) {
        itemCarrinhoUsecase.updateItemCarrinho(id, itemCarrinhoModel);
    }

    @DeleteMapping("/{id}")
    public void removerItemCarrinho(@PathVariable int id) {
        itemCarrinhoUsecase.removeItemCarrinho(id);
    }
} 