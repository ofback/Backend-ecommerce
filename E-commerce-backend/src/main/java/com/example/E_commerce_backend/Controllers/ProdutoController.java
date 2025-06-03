package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.ProdutoModel;
import com.example.E_commerce_backend.Usecases.ProdutoUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoUsecase produtoUsecase;

    @Autowired
    public ProdutoController(ProdutoUsecase produtoUsecase) {
        this.produtoUsecase = produtoUsecase;
    }

    @GetMapping
    public List<ProdutoModel> listarTodos() {
        return produtoUsecase.obterTodosProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarPorId(@PathVariable int id) {
        return produtoUsecase.obterProdutoPorId(id);
    }

    @PostMapping
    public void criarProduto(@RequestBody ProdutoModel produtoModel) {
        produtoUsecase.criarProduto(produtoModel);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable int id, @RequestBody ProdutoModel produtoModel) {
        produtoUsecase.atualizarProduto(id, produtoModel);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable int id) {
        produtoUsecase.removerProduto(id);
    }
} 