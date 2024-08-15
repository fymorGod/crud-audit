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
    private int qtdItens;

    @Column
    private int qtdConferida;

    @Column
    @Enumerated(EnumType.STRING)
    private Conferido conferido;

    @Column
    private int qtdAuditada;

    @Column
    @Enumerated(EnumType.STRING)
    private Auditado auditado;

    @Column
    private String cliente;

    @Column
    private String prenota;

    @Column
    private int cpf;

    @Column
    private String emb;

    @CreationTimestamp(source = SourceType.DB)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
