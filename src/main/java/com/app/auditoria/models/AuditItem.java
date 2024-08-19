package com.app.auditoria.models;

import com.app.auditoria.enums.Auditado;
import com.app.auditoria.enums.Conferido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "AUDITITEM", schema = "EPORTAL")
@NoArgsConstructor
@AllArgsConstructor
public class AuditItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String romaneio;

    @Column
    private String codProduto;

    @Column
    private String descricao;

    @Column
    private String eanProduto;

    @Column
    private String emb;

    @Column(name = "QTD_ITENS")
    private Long qtdItens;

    @Column(name = "QTD_CONFERIDA")
    private Long qtdConferida;

    @Column
    @Enumerated(EnumType.STRING)
    private Conferido conferido;

    @Column(name = "QTD_AUDITADA")
    private Long qtdAuditada;

    @Column
    @Enumerated(EnumType.STRING)
    private Auditado auditado;

    @CreationTimestamp(source = SourceType.DB)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
