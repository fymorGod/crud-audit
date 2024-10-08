package com.app.auditoria.dtos;

import com.app.auditoria.enums.Auditado;
import com.app.auditoria.enums.Conferido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AuditItemUpdateDto(
        @NotNull
        int id,
        long qtdAuditada,
        String eanProduto
) {
}
