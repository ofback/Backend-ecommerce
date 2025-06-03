package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.UserModel;
import com.example.E_commerce_backend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUsecase {
    private final UserRepository userRepository;

    public UserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> obterTodosUsuarios() {
        return userRepository.buscar();
    }

    public UserModel obterUsuarioPorId(int id) {
        return userRepository.searchByCode(id);
    }

    public void criarUser(UserModel userModel) {
        UserModel admin = new UserModel(
                userModel.getNome(),
                userModel.getEmail(),
                userModel.getSenha()
        );
    }

    public void removeUser(int id) {
        userRepository.removeUser(id);
    }

    public void updateUser(int id, UserModel userModel) {
        userRepository.updateUser((int) id, userModel);
    }
}
