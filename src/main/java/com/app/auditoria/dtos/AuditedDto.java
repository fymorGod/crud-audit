package com.app.auditoria.dtos;

import com.app.auditoria.enums.Auditado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AuditedDto(

        String romaneio,
        @NotNull
        @Enumerated(EnumType.STRING)
        Auditado auditado
) {
}
