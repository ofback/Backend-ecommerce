package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.FavoritoModel;
import com.example.E_commerce_backend.Usecases.FavoritoUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorito")
public class FavoritoController {

    private final FavoritoUsecase favoritoUsecase;

    @Autowired
    public FavoritoController(FavoritoUsecase favoritoUsecase) {
        this.favoritoUsecase = favoritoUsecase;
    }

    @GetMapping
    public List<FavoritoModel> listarTodos() {
        return favoritoUsecase.listarTodos();
    }

    @GetMapping("/{id}")
    public FavoritoModel buscarPorId(@PathVariable int id) {
        return favoritoUsecase.obterFavoritoPorId(id);
    }

    @PostMapping
    public void criarFavorito(@RequestBody FavoritoModel favoritoModel) {
        favoritoUsecase.addFavorito(favoritoModel);
    }

    @PutMapping("/{id}")
    public void atualizarFavorito(@PathVariable int id, @RequestBody FavoritoModel favoritoModel) {
        favoritoUsecase.updateFavorito(id, favoritoModel);
    }

    @DeleteMapping("/{id}")
    public void removerFavorito(@PathVariable int id) {
        favoritoUsecase.removeFavorito(id);
    }
} 