package com.app.auditoria.services;

import com.app.auditoria.models.AuditItem;
import com.app.auditoria.repositories.AuditItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditItemService {

    private final AuditItemRepository auditItemRepository;

    @Transactional
    public void save(AuditItem auditItem) {
        auditItemRepository.save(auditItem);
    }

    public List<AuditItem> getAll() {
        return auditItemRepository.findAll();
    }

    public Optional<AuditItem> findById(int id) {
        return auditItemRepository.findById(id);
    }

    public Optional<AuditItem> findByRomaneio(String romaneio) {
        return auditItemRepository.findByRomaneio(romaneio);
    }
}
