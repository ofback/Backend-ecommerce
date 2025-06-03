package com.example.E_commerce_backend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "favorito")
public class FavoritoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoModel produto;

    public FavoritoModel() {
    }

    public FavoritoModel(UserModel usuario, ProdutoModel produto) {
        this.usuario = usuario;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
