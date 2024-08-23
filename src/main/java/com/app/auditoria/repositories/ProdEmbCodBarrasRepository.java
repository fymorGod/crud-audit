package com.app.auditoria.repositories;

import com.app.auditoria.models.ProdEmbCodBarras;
import com.app.auditoria.models.ProdEmbCodBarrasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdEmbCodBarrasRepository extends JpaRepository<ProdEmbCodBarras, ProdEmbCodBarrasId> {
    List<ProdEmbCodBarras> findAllByProdutoIeAndEmbalagemIe(long produtoIe, long embalagemIe);
}