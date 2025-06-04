package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.PromocaoModel;
import com.example.E_commerce_backend.Usecases.PromocaoUsecase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promocoes")
public class PromocaoController {
    private final PromocaoUsecase promocaoUsecase;

    public PromocaoController(PromocaoUsecase promocaoUsecase) {
        this.promocaoUsecase = promocaoUsecase;
    }

    @GetMapping
    public ResponseEntity<List<PromocaoModel>> listarTodasPromocoes() {
        List<PromocaoModel> promocoes = promocaoUsecase.obterTodasPromocoes();
        return ResponseEntity.ok(promocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocaoModel> obterPromocaoPorId(@PathVariable int id) {
        PromocaoModel promocao = promocaoUsecase.obterPromocaoPorId(id);
        if (promocao != null) {
            return ResponseEntity.ok(promocao);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> criarPromocao(@RequestBody PromocaoModel promocao) {
        promocaoUsecase.criarPromocao(promocao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPromocao(@PathVariable int id, @RequestBody PromocaoModel promocao) {
        PromocaoModel promocaoExistente = promocaoUsecase.obterPromocaoPorId(id);
        if (promocaoExistente != null) {
            promocaoUsecase.atualizarPromocao(id, promocao);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPromocao(@PathVariable int id) {
        PromocaoModel promocao = promocaoUsecase.obterPromocaoPorId(id);
        if (promocao != null) {
            promocaoUsecase.removerPromocao(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
} 