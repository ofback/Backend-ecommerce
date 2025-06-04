package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.CategoriaModel;
import com.example.E_commerce_backend.Usecases.CategoriaUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria") // Base path for all category-related endpoints
public class CategoriaController {

    private final CategoriaUsecase categoriaUsecase;

    @Autowired
    public CategoriaController(CategoriaUsecase categoriaUsecase) {
        this.categoriaUsecase = categoriaUsecase;
    }

    @GetMapping
    public List<CategoriaModel> listarTodas() {
        // Calls the use case method to get all categories
        return categoriaUsecase.obterTodasCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaModel buscarPorId(@PathVariable int id) {
        // Calls the use case method to get a category by its ID
        return categoriaUsecase.obterCategoriaPorId(id);
    }

    @PostMapping
    public void criarCategoria(@RequestBody CategoriaModel categoriaModel) {
        // Calls the use case method to create a new category
        categoriaUsecase.criarCategoria(categoriaModel);
    }

    @PutMapping("/{id}")
    public void atualizarCategoria(@PathVariable int id, @RequestBody CategoriaModel categoriaModel) {
        // Calls the use case method to update an existing category
        categoriaUsecase.updateCategoria(id, categoriaModel);
    }

    @DeleteMapping("/{id}")
    public void removerCategoria(@PathVariable int id) {
        // Calls the use case method to remove a category by its ID
        categoriaUsecase.removeCategoria(id);
    }
}