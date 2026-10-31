package com.senai.lojapi.repository;

import com.senai.lojapi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acesso ao banco. O Spring Data JPA ja implementa findAll, findById,
 * save e deleteById automaticamente.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
