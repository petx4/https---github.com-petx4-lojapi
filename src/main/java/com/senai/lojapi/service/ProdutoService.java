package com.senai.lojapi.service;

import com.senai.lojapi.entity.Produto;
import com.senai.lojapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada Service: fica entre o Controller e o Repository.
 * Aqui ficam as regras de negocio (validacoes, calculos, decisoes).
 * O Controller so recebe a requisicao e repassa para ca.
 */
@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Usado pelo GET /produtos
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // Usado pelo GET /produtos/{id}
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Usado pelo POST /produtos
    public Produto cadastrar(Produto produto) {
        // Exemplo de regra de negocio: nao aceitar preco ou quantidade negativos
        if (produto.getPreco() == null || produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preco nao pode ser negativo");
        }
        if (produto.getQuantidade() == null || produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa");
        }
        return repository.save(produto);
    }
}
