package com.app.auditoria.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AuditItemResponse {
    private Long id;
    private String romaneio;
    private List<String> codigosDeBarras;
}
