package com.app.auditoria.repositories;

import com.app.auditoria.models.AuditItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditItemRepository extends JpaRepository<AuditItem, Integer> {
    Optional<AuditItem> findByRomaneio(String romaneio);
}
