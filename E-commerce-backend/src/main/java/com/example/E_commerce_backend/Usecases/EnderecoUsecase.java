package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.EnderecoModel;
import com.example.E_commerce_backend.Repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoUsecase {

    private final EnderecoRepository enderecoRepository;

    public EnderecoUsecase(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoModel> listarTodos() {
        return enderecoRepository.buscar();
    }

    public EnderecoModel obterEnderecoPorId(int id) {
        return enderecoRepository.searchByCode(id);
    }

    public void addEndereco(EnderecoModel enderecoModel) {
        enderecoRepository.addEndereco(enderecoModel);
    }

    public void updateEndereco(int id, EnderecoModel enderecoModel) {
        enderecoRepository.updateEndereco(id, enderecoModel);
    }

    public void removeEndereco(int id) {
        enderecoRepository.removeEndereco(id);
    }

    public boolean estaVazio() {
        return enderecoRepository.estaVazio();
    }
}
