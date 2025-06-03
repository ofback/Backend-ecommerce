package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.ItemCarrinhoModel;
import com.example.E_commerce_backend.Repositories.ItemCarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoUsecase {
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinhoUsecase(ItemCarrinhoRepository itemCarrinhoRepository) {
        this.itemCarrinhoRepository = itemCarrinhoRepository;
    }

    public List<ItemCarrinhoModel> obterTodosItensCarrinho() {
        return itemCarrinhoRepository.buscar();
    }

    public ItemCarrinhoModel obterItemCarrinhoPorId(int id) {
        return itemCarrinhoRepository.searchByCode(id);
    }

    public void criarItemCarrinho(ItemCarrinhoModel itemCarrinhoModel) {
        itemCarrinhoRepository.addItem(itemCarrinhoModel);
    }

    public void updateItemCarrinho(int id, ItemCarrinhoModel itemCarrinhoModel) {
        itemCarrinhoRepository.updateItem(id, itemCarrinhoModel);
    }

    public void removeItemCarrinho(int id) {
        itemCarrinhoRepository.removeItem(id);
    }
} 