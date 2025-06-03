package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.UserModel;
import com.example.E_commerce_backend.Usecases.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserUsecase userUsecase;

    @Autowired
    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    @GetMapping
    public List<UserModel> listarTodos() {
        return userUsecase.obterTodosUsuarios();
    }

    @GetMapping("/{id}")
    public UserModel buscarPorId(@PathVariable int id) {
        return userUsecase.obterUsuarioPorId(id);
    }

    @PostMapping
    public void criarUsuario(@RequestBody UserModel userModel) {

        userUsecase.criarUser(userModel);
    }

    @PutMapping("/{id}")
    public void atualizarUsuario(@PathVariable int id, @RequestBody UserModel userModel) {
        userUsecase.updateUser(id, userModel);;
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable int id) {
        userUsecase.removeUser(id);
    }
}
