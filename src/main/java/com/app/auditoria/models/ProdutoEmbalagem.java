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
@IdClass(ProdutoEmbalagemId.class)
@Table(schema = "DBAWMS", name = "TW501_PRODUTO_EMBALAGEM")
public class ProdutoEmbalagem {
    @Id
    @Column(name = "TW501_PRODUTO_IE")
    private long produtoIe;

    @Id
    @Column(name = "TW501_EMBALAGEM_IU")
    private long embalagemIu;

    @Column(name = "TW501_BLOQUEADA")
    private String bloqueada;
}
