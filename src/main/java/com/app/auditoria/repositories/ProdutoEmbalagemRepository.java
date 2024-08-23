package com.app.auditoria.repositories;

import com.app.auditoria.models.ProdutoEmbalagem;
import com.app.auditoria.models.ProdutoEmbalagemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, ProdutoEmbalagemId> {
    List<ProdutoEmbalagem> findAllByProdutoIe(long produtoIe);
}
