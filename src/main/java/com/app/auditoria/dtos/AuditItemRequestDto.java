package com.app.auditoria.dtos;

import com.app.auditoria.enums.Auditado;
import com.app.auditoria.enums.Conferido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AuditItemRequestDto(
        @NotNull
        String romaneio,
        @NotNull
        String codProduto,
        @NotNull
        String descricao,
        @NotNull
        String eanProduto,
        @NotNull
        int qtdItens,
        @NotNull
        int qtdConferida,
        @NotNull
        @Enumerated(EnumType.STRING)
        Conferido conferido,
        @NotNull
        int qtdAuditada,
        @NotNull
        @Enumerated(EnumType.STRING)
        Auditado auditado
) {
}
