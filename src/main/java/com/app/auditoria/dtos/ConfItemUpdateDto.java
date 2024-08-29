package com.app.auditoria.dtos;

import com.app.auditoria.enums.Conferido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record ConfItemUpdateDto(
        @NotNull
        int id,

        long qtdConferido,
        @NotNull
        @Enumerated(EnumType.STRING)
        Conferido conferido
) {
}
