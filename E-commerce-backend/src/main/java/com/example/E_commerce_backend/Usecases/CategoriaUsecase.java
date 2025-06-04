package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.CategoriaModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoriaUsecase {
    List<CategoriaModel> buscar();
    CategoriaModel searchByCode(int id);
    void addCategoria(CategoriaModel categoriaModel);
    void updateCategoria(int id, CategoriaModel categoriaModel);
    void removeCategoria(int id);
    boolean estaVazio();
} 