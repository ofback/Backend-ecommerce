package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.CategoriaModel;
import com.example.E_commerce_backend.Repositories.CategoriaRepository;
import com.example.E_commerce_backend.jpa.CategoriaJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaImplementation implements CategoriaRepository {

    private final CategoriaJpa categoriaJpa;

    @Autowired
    public CategoriaImplementation(CategoriaJpa categoriaJpa) {
        this.categoriaJpa = categoriaJpa;
    }

    @Override
    public List<CategoriaModel> buscar() {
        return categoriaJpa.findAll();
    }

    @Override
    public CategoriaModel searchByCode(int id) {
        return categoriaJpa.findById(id).orElse(null);
    }

    @Override
    public void addCategoria(CategoriaModel categoriaModel) {
        categoriaJpa.save(categoriaModel);
    }

    @Override
    public void updateCategoria(int id, CategoriaModel categoriaModel) {
        CategoriaModel enderecoInDb = categoriaJpa.findById(id).orElse(null);

        if (enderecoInDb != null) {
            // Atualiza o campo 'tipo' da categoria existente com o valor da categoriaModel fornecida.
            // Como 'tipo' é um int primitivo, getTipo() sempre retornará um valor.
            enderecoInDb.setTipo(categoriaModel.getTipo());

            categoriaJpa.save(enderecoInDb);
        }
    }

    @Override
    public void removeCategoria(int id) {
        categoriaJpa.deleteById(id);
    }

    @Override
    public boolean estaVazio() {
        return categoriaJpa.count() == 0;
    }
}