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
public class ProdEmbCodBarrasId {
    @Column(name = "TW502_PRODUTO_IE")
    private long produtoIe;
    @Column(name = "TW502_EMBALAGEM_IE")
    private long embalagemIe;
    @Column(name = "TW502_COD_BARRAS_IU")
    private String codBarrasIu;
}
