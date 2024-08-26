package com.app.auditoria.services;

import com.app.auditoria.dtos.AuditItemDetailsDTO;
import com.app.auditoria.models.AuditItem;
import com.app.auditoria.models.ProdEmbCodBarras;
import com.app.auditoria.models.ProdutoEmbalagem;
import com.app.auditoria.repositories.AuditItemRepository;
import com.app.auditoria.repositories.ProdEmbCodBarrasRepository;
import com.app.auditoria.repositories.ProdutoEmbalagemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditItemService {

    private final AuditItemRepository auditItemRepository;
    private final ProdutoEmbalagemRepository produtoEmbalagemRepository;
    private final ProdEmbCodBarrasRepository prodEmbCodBarrasRepository;

    public List<AuditItemDetailsDTO> getAuditItemDetailsByRomaneio(String romaneio) {
        List<AuditItem> auditItems = auditItemRepository.findByRomaneio(romaneio);

        if (auditItems.isEmpty()) {
            throw new EntityNotFoundException("Nenhum AuditItem encontrado para o romaneio: " + romaneio);
        }

        List<AuditItemDetailsDTO> auditItemDetailsList = new ArrayList<>();

        for (AuditItem auditItem : auditItems) {
            long codProdutoLong;
            try {
                codProdutoLong = Long.parseLong(auditItem.getCodProduto());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("CodProduto não é um número válido: " + auditItem.getCodProduto());
            }

            List<ProdutoEmbalagem> produtoEmbalagemList = produtoEmbalagemRepository.findAllByProdutoIe(codProdutoLong);

            // Iterar sobre cada ProdutoEmbalagem e buscar os códigos de barras associados
            for (ProdutoEmbalagem produtoEmbalagem : produtoEmbalagemList) {
                List<ProdEmbCodBarras> prodEmbCodBarrasList = prodEmbCodBarrasRepository.findAllByProdutoIeAndEmbalagemIe(
                        produtoEmbalagem.getProdutoIe(), produtoEmbalagem.getEmbalagemIu());

                for (ProdEmbCodBarras prodEmbCodBarras : prodEmbCodBarrasList) {
                    AuditItemDetailsDTO dto = AuditItemDetailsDTO.from(
                            auditItem,
                            produtoEmbalagem,
                            prodEmbCodBarras
                    );

                    auditItemDetailsList.add(dto);
                }
            }
        }

        return auditItemDetailsList;
    }
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

}
