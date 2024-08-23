package com.app.auditoria.dtos;

import com.app.auditoria.enums.Auditado;
import com.app.auditoria.enums.Conferido;
import com.app.auditoria.models.AuditItem;
import com.app.auditoria.models.ProdEmbCodBarras;
import com.app.auditoria.models.ProdutoEmbalagem;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class AuditItemDetailsDTO {

    @NotNull
    private int id;

    private String romaneio;
    private String codProduto;
    private String descricao;
    private String emb;
    private String eanProduto;
    private Long qtdItens;
    private Long qtdConferida;
    private Conferido conferido;
    private Long qtdAuditada;
    private Auditado auditado;
    private String codBarrasIu;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AuditItemDetailsDTO from(AuditItem auditItem, ProdutoEmbalagem produtoEmbalagem, ProdEmbCodBarras prodEmbCodBarras) {
        return AuditItemDetailsDTO.builder()
                .id(auditItem.getId())
                .romaneio(auditItem.getRomaneio())
                .codProduto(auditItem.getCodProduto())
                .descricao(auditItem.getDescricao())
                .emb(auditItem.getEmb())
                .eanProduto(auditItem.getEanProduto())
                .qtdItens(auditItem.getQtdItens())
                .qtdConferida(auditItem.getQtdConferida())
                .conferido(auditItem.getConferido())
                .qtdAuditada(auditItem.getQtdAuditada())
                .auditado(auditItem.getAuditado())
                .codBarrasIu(prodEmbCodBarras != null ? prodEmbCodBarras.getCodBarrasIu() : null)
                .createdAt(auditItem.getCreatedAt())
                .updatedAt(auditItem.getUpdatedAt())
                .build();
    }
}
