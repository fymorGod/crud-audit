package com.app.auditoria.repositories;

import com.app.auditoria.models.AuditItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditItemRepository extends JpaRepository<AuditItem, Integer> {
    List<AuditItem> findByRomaneio(String romaneio);
}
