package com.example.E_commerce_backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    private int tipo;

    public CategoriaModel(int id, int tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}