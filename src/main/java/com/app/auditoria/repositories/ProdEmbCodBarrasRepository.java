package com.app.auditoria.repositories;

import com.app.auditoria.models.ProdEmbCodBarras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdEmbCodBarrasRepository extends JpaRepository<ProdEmbCodBarras, Long> {
}