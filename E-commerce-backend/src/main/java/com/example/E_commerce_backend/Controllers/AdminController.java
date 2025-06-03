package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.AdminModel;
import com.example.E_commerce_backend.Usecases.AdminUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminUsecase adminUsecase;

    @Autowired
    public AdminController(AdminUsecase adminUsecase) {
        this.adminUsecase = adminUsecase;
    }

    @GetMapping
    public List<AdminModel> listarTodos() {
        return adminUsecase.obterTodosUsuarios();
    }

    @GetMapping("/{id}")
    public AdminModel buscarPorId(@PathVariable int id) {
        return adminUsecase.obterAdminPorId(id);
    }

    @PostMapping
    public void criarAdmin(@RequestBody AdminModel adminModel) {
        adminUsecase.criarAdmin(adminModel);
    }

    @PutMapping("/{id}")
    public void atualizarAdmin(@PathVariable int id, @RequestBody AdminModel adminModel) {
        adminUsecase.updateAdmin(id, adminModel);
    }

    @DeleteMapping("/{id}")
    public void removerAdmin(@PathVariable int id) {
        adminUsecase.removeAdmin(id);
    }
}
