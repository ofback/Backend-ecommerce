package com.example.E_commerce_backend.Implementations;

import com.example.E_commerce_backend.Models.EnderecoModel;
import com.example.E_commerce_backend.Repositories.EnderecoRepository;
import com.example.E_commerce_backend.jpa.EnderecoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnderecoImplementation implements EnderecoRepository {

    private final EnderecoJpa enderecoJpa;

    @Autowired
    public EnderecoImplementation(EnderecoJpa enderecoJpa) {
        this.enderecoJpa = enderecoJpa;
    }

    @Override
    public List<EnderecoModel> buscar() {
        return enderecoJpa.findAll();
    }

    @Override
    public EnderecoModel searchByCode(int id) {
        return enderecoJpa.findById(id).orElse(null);
    }

    @Override
    public void addEndereco(EnderecoModel enderecoModel) {
        enderecoJpa.save(enderecoModel);
    }

    @Override
    public void updateEndereco(int id, EnderecoModel enderecoModel) {
        EnderecoModel enderecoInDb = enderecoJpa.findById(id).orElse(null);
        if (enderecoInDb != null) {
            enderecoInDb.setRua(enderecoModel.getRua());
            enderecoInDb.setCidade(enderecoModel.getCidade());
            enderecoInDb.setEstado(enderecoModel.getEstado());
            enderecoInDb.setCep(enderecoModel.getCep());
            enderecoInDb.setPrincipal(enderecoModel.isPrincipal());
            enderecoInDb.setUsuario(enderecoModel.getUsuario());


            enderecoJpa.save(enderecoInDb);
        }
    }

    @Override
    public void removeEndereco(int id) {
        enderecoJpa.deleteById(id);
    }

    @Override
    public boolean estaVazio() {
        return enderecoJpa.count() == 0;
    }
}
