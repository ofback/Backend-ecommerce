package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.CategoriaModel;
import com.example.E_commerce_backend.Usecases.CategoriaUsecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaUsecase categoriaUsecase;

    @Autowired
    public CategoriaController(CategoriaUsecase categoriaUsecase) {
        this.categoriaUsecase = categoriaUsecase;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> buscar() {
        return ResponseEntity.ok(categoriaUsecase.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> searchByCode(@PathVariable int id) {
        CategoriaModel categoria = categoriaUsecase.searchByCode(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addCategoria(@RequestBody CategoriaModel categoriaModel) {
        categoriaUsecase.addCategoria(categoriaModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategoria(@PathVariable int id, @RequestBody CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaUsecase.searchByCode(id);
        if (categoria != null) {
            categoriaUsecase.updateCategoria(id, categoriaModel);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCategoria(@PathVariable int id) {
        CategoriaModel categoria = categoriaUsecase.searchByCode(id);
        if (categoria != null) {
            categoriaUsecase.removeCategoria(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 