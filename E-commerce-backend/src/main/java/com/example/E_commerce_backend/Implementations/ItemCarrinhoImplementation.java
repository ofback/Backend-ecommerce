package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.ItemCarrinhoModel;
import com.example.E_commerce_backend.Repositories.ItemCarrinhoRepository;
import com.example.E_commerce_backend.jpa.ItemCarrinhoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemCarrinhoImplementation implements ItemCarrinhoRepository {

    private final ItemCarrinhoJpa itemCarrinhoJpa;

    @Autowired
    public ItemCarrinhoImplementation(ItemCarrinhoJpa itemCarrinhoJpa) {
        this.itemCarrinhoJpa = itemCarrinhoJpa;
    }

    @Override
    public List<ItemCarrinhoModel> buscar() {
        return itemCarrinhoJpa.findAll();
    }

    @Override
    public ItemCarrinhoModel searchByCode(int id) {
        return itemCarrinhoJpa.findById(id).orElse(null);
    }

    @Override
    public void addItem(ItemCarrinhoModel itemCarrinhoModel) {
        itemCarrinhoJpa.save(itemCarrinhoModel);
    }

    @Override
    public void updateItem(int id, ItemCarrinhoModel itemCarrinhoModel) {
        ItemCarrinhoModel itemInDb = itemCarrinhoJpa.findById(id).orElse(null);
        if (itemInDb != null) {
            itemInDb.setCarrinho(itemCarrinhoModel.getCarrinho());
            itemInDb.setProduto(itemCarrinhoModel.getProduto());
            itemInDb.setQuantidade(itemCarrinhoModel.getQuantidade());

            itemCarrinhoJpa.save(itemInDb);
        }
    }

    @Override
    public void removeItem(int id) {
        itemCarrinhoJpa.deleteById(id);
    }

    @Override
    public boolean estaVazio() {
        return itemCarrinhoJpa.count() == 0;
    }
}
