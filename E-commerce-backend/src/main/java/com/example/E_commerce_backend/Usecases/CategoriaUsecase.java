package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.CategoriaModel;
import com.example.E_commerce_backend.Repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUsecase {
    private final CategoriaRepository categoriaRepository;

    public CategoriaUsecase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> obterTodasCategorias() {
        return categoriaRepository.buscar();
    }

    public CategoriaModel obterCategoriaPorId(int id) { // Parâmetro 'id'
        return categoriaRepository.searchByCode(id);
    }

    public void criarCategoria(CategoriaModel categoriaModel) { // Parâmetro 'categoriaModel'
        categoriaRepository.addCategoria(categoriaModel);
    }

    public void updateCategoria(int id, CategoriaModel categoriaModel) { // Parâmetros 'id' e 'categoriaModel'
        categoriaRepository.updateCategoria(id, categoriaModel);
    }

    public void removeCategoria(int id) { // Parâmetro 'id'
        categoriaRepository.removeCategoria(id);
    }
}