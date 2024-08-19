package com.app.auditoria.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoEmbalagemId {
    @Column(name = "TW501_PRODUTO_IE")
    private long produtoIe;
    @Column(name = "TW501_EMBALAGEM_IU")
    private long embalagemIu;
}

