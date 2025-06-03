package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.EnderecoModel;
import com.example.E_commerce_backend.Usecases.EnderecoUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoUsecase enderecoUsecase;

    @Autowired
    public EnderecoController(EnderecoUsecase enderecoUsecase) {
        this.enderecoUsecase = enderecoUsecase;
    }

    @GetMapping
    public List<EnderecoModel> listarTodos() {
        return enderecoUsecase.listarTodos();
    }

    @GetMapping("/{id}")
    public EnderecoModel buscarPorId(@PathVariable int id) {
        return enderecoUsecase.obterEnderecoPorId(id);
    }

    @PostMapping
    public void criarEndereco(@RequestBody EnderecoModel enderecoModel) {
        enderecoUsecase.addEndereco(enderecoModel);
    }

    @PutMapping("/{id}")
    public void atualizarEndereco(@PathVariable int id, @RequestBody EnderecoModel enderecoModel) {
        enderecoUsecase.updateEndereco(id, enderecoModel);
    }

    @DeleteMapping("/{id}")
    public void removerEndereco(@PathVariable int id) {
        enderecoUsecase.removeEndereco(id);
    }
} 