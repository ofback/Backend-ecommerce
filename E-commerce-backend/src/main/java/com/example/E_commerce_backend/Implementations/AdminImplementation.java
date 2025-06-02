package com.example.E_commerce_backend.Implementations;


import com.example.E_commerce_backend.Models.AdminModel;
import com.example.E_commerce_backend.jpa.AdminJpa;
import com.example.E_commerce_backend.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminImplementation implements AdminRepository {
    private final AdminJpa adminJpa;

    @Autowired

    public AdminImplementation(AdminJpa adminJpa) {
        this.adminJpa = adminJpa;
    }
    @Override
    public AdminModel searchByCode(int id) {
        return this.adminJpa.findById(id).orElse(null);
    }

    @Override
    public List<AdminModel> buscar() {
        return this.adminJpa.findAll();
    }

    @Override
    public void addAdmin(AdminModel adminModel) {
        this.adminJpa.save(adminModel);
    }

    @Override
    public void removeAdmin(int id) {
        this.adminJpa.deleteById(id);
    }

    @Override
    public void updateAdmin(int id, AdminModel AdminModel) {
        AdminModel adminModelInDb = this.adminJpa.findById(id).orElse(null);
        if (adminModelInDb != null) {

            adminModelInDb.setNome(AdminModel.getNome());
            adminModelInDb.setEmail(AdminModel.getEmail());
            adminModelInDb.setCpf(AdminModel.getCpf());
            adminModelInDb.setDataNascimento(AdminModel.getDataNascimento());


            this.adminJpa.save(adminModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.adminJpa.count() == 0;
    }

}
