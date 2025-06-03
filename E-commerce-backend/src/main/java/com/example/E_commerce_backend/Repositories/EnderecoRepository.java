package com.example.E_commerce_backend.Repositories;

import com.example.E_commerce_backend.Models.EnderecoModel;

import java.util.List;

public interface EnderecoRepository {
    List<EnderecoModel> buscar();
    EnderecoModel searchByCode(int id);
    void addEndereco(EnderecoModel enderecoModel);
    void updateEndereco(int id, EnderecoModel enderecoModel);
    void removeEndereco(int id);
    boolean estaVazio();
}
