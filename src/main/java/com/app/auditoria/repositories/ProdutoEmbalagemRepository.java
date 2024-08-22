package com.app.auditoria.repositories;

import com.app.auditoria.models.ProdutoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoEmbalagemRepository extends JpaRepository<ProdutoEmbalagem, Long> {
}
