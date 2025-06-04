package com.example.E_commerce_backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "promocao")
public class PromocaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double precoReal;
    private double precoPromocional;

    public PromocaoModel() {
    }

    public PromocaoModel(double precoReal, double precoPromocional) {
        this.precoReal = precoReal;
        this.precoPromocional = precoPromocional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoReal() {
        return precoReal;
    }

    public void setPrecoReal(double precoReal) {
        this.precoReal = precoReal;
    }

    public double getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(double precoPromocional) {
        this.precoPromocional = precoPromocional;
    }
} 