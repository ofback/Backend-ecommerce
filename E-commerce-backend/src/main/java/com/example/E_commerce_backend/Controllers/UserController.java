package com.example.E_commerce_backend.Controllers;

import com.example.E_commerce_backend.Models.UserModel;
import com.example.E_commerce_backend.Usecases.UserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UserController {

    private final UserUsecase userUsecase;

    @Autowired
    public UserController(UserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> listarTodos() {
        return ResponseEntity.ok(userUsecase.obterTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> buscarPorId(@PathVariable int id) {
        UserModel user = userUsecase.obterUsuarioPorId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody UserModel userModel) {
        userUsecase.criarUser(userModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable int id, @RequestBody UserModel userModel) {
        userUsecase.updateUser(id, userModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable int id) {
        userUsecase.removeUser(id);
        return ResponseEntity.noContent().build();
    }
}
