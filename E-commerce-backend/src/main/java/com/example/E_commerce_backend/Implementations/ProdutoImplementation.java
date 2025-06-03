package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.ProdutoModel;
import com.example.E_commerce_backend.jpa.ProdutoJpa;
import com.example.E_commerce_backend.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoImplementation implements ProdutoRepository {

    private final ProdutoJpa produtoJpa;

    @Autowired
    public ProdutoImplementation(ProdutoJpa produtoJpa) {
        this.produtoJpa = produtoJpa;
    }

    @Override
    public ProdutoModel searchByCode(int id) {
        return this.produtoJpa.findById(id).orElse(null);
    }

    @Override
    public List<ProdutoModel> buscar() {
        return this.produtoJpa.findAll();
    }

    @Override
    public void addProduto(ProdutoModel productModel) {
        this.produtoJpa.save(productModel);
    }

    @Override
    public void removeProduto(int id) {
        this.produtoJpa.deleteById(id);
    }

    @Override
    public void updateProduto(int id, ProdutoModel productModel) {
        ProdutoModel produtoInDb = this.produtoJpa.findById(id).orElse(null);
        if (produtoInDb != null) {
            produtoInDb.setNome(productModel.getNome());
            produtoInDb.setDescricao(productModel.getDescricao());
            produtoInDb.setPreco(productModel.getPreco());
            produtoInDb.setEstoque(productModel.getEstoque());
            produtoInDb.setImagemUrl(productModel.getImagemUrl());

            this.produtoJpa.save(produtoInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.produtoJpa.count() == 0;
    }
}
