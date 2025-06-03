package com.example.E_commerce_backend.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carrinhos")
public class CarrinhoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinhoModel> itens;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public CarrinhoModel() {}

    public CarrinhoModel(int usuarioId, List<ItemCarrinhoModel> itens, LocalDateTime atualizadoEm) {
        this.usuarioId = usuarioId;
        this.itens = itens;
        this.atualizadoEm = atualizadoEm;
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemCarrinhoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoModel> itens) {
        this.itens = itens;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
