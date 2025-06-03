package com.example.E_commerce_backend.Usecases;

import com.example.E_commerce_backend.Models.ProdutoModel;
import com.example.E_commerce_backend.Repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public ProdutoUsecase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> obterTodosProdutos() {
        return produtoRepository.buscar();
    }

    public ProdutoModel obterProdutoPorId(int id) {
        return produtoRepository.searchByCode(id);
    }

    public void criarProduto(ProdutoModel produtoModel) {
        ProdutoModel novoProduto = new ProdutoModel(
                produtoModel.getNome(),
                produtoModel.getDescricao(),
                produtoModel.getPreco(),
                produtoModel.getEstoque(),
                produtoModel.getImagemUrl()
        );

        produtoRepository.addProduto(novoProduto);
    }

    public void removerProduto(int id) {
        produtoRepository.removeProduto(id);
    }

    public void atualizarProduto(int id, ProdutoModel produtoModel) {
        produtoRepository.updateProduto(id, produtoModel);
    }
}
