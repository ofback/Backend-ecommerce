package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.PromocaoModel;
import com.example.E_commerce_backend.Repositories.PromocaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoUsecase {
    private final PromocaoRepository promocaoRepository;

    public PromocaoUsecase(PromocaoRepository promocaoRepository) {
        this.promocaoRepository = promocaoRepository;
    }

    public List<PromocaoModel> obterTodasPromocoes() {
        return promocaoRepository.buscar();
    }

    public PromocaoModel obterPromocaoPorId(int id) {
        return promocaoRepository.searchByCode(id);
    }

    public void criarPromocao(PromocaoModel promocaoModel) {
        promocaoRepository.addPromocao(promocaoModel);
    }

    public void atualizarPromocao(int id, PromocaoModel promocaoModel) {
        promocaoRepository.updatePromocao(id, promocaoModel);
    }

    public void removerPromocao(int id) {
        promocaoRepository.removePromocao(id);
    }

    public boolean estaVazio() {
        return promocaoRepository.estaVazio();
    }
} 