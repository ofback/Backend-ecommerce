package com.example.E_commerce_backend.Implementations;


import com.example.E_commerce_backend.Models.UserModel;
import com.example.E_commerce_backend.jpa.UserJpa;
import com.example.E_commerce_backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImplementation implements UserRepository {
    private final UserJpa userJpa;

    @Autowired
    public UserImplementation(UserJpa userJpa) {
        this.userJpa = userJpa;
    }
    @Override
    public UserModel searchByCode(int id) {
        return this.userJpa.findById(id).orElse(null);
    }

    @Override
    public List<UserModel> buscar() {
        return this.userJpa.findAll();
    }

    @Override
    public void addUser(UserModel userModel) {
        this.userJpa.save(userModel);
    }

    @Override
    public void removeUser(int id) {
        this.userJpa.deleteById(id);
    }

    @Override
    public void updateUser(int id, UserModel userModel) {
        UserModel userModelInDb = this.userJpa.findById(id).orElse(null);
        if (userModelInDb != null) {

            userModelInDb.setNome(userModel.getNome());
            userModelInDb.setEmail(userModel.getEmail());

            this.userJpa.save(userModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.userJpa.count() == 0;
    }

}
