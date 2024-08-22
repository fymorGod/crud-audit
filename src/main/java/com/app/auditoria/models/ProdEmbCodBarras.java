package com.app.auditoria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(ProdEmbCodBarrasId.class)
@Table(schema = "DBAWMS", name = "TW502_PROD_EMB_COD_CODBARRAS")
public class ProdEmbCodBarras {
    @Id
    @Column(name = "TW502_PRODUTO_IE")
    private long produtoIe;

    @Id
    @Column(name = "TW502_EMBALAGEM_IE")
    private long embalagemIe;

    @Id
    @Column(name = "TW502_COD_BARRAS_IU")
    private String codBarrasIu;

}
