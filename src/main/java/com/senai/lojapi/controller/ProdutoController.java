package com.senai.lojapi.controller;

import com.senai.lojapi.entity.Produto;
import com.senai.lojapi.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints REST que o front-end chama:
 *
 *  GET  /produtos       : lista todos os produtos
 *  GET  /produtos/{id}  : busca um produto pelo id
 *  POST /produtos       : cadastra um novo produto
 *
 * O Controller nao fala direto com o banco: ele chama o ProdutoService.
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(service.cadastrar(produto));
        } catch (IllegalArgumentException e) {
            // Regra do Service foi violada: devolve 400 com a mensagem
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
