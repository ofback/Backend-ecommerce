package com.example.E_commerce_backend.Usecases;


import com.example.E_commerce_backend.Models.AdminModel;
import com.example.E_commerce_backend.Repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUsecase {
    private final AdminRepository adminRepository;

    public AdminUsecase(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminModel> obterTodosUsuarios() {
        return adminRepository.buscar();
    }

    public AdminModel obterUsuarioPorId(int id) {
        return adminRepository.searchByCode(id);
    }

    public void criarAdmin(AdminModel adminModel) {
        AdminModel admin = new AdminModel(
                adminModel.getNome(),
                adminModel.getCpf(),
                adminModel.getDataNascimento(),
                adminModel.getEmail(),
                adminModel.getSenha()
        );
    }

    public void removeAdmin(int id) {
        adminRepository.removeAdmin(id);
    }

    public void updateAdmin(int id, AdminModel adminModel) {
        adminRepository.updateAdmin((int) id, adminModel);
    }
}
