package com.projeto1N.exemplo1N.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_prod;

    public Produto(Long codigo_prod, String nome_prod, Double perco_prod, Empresa empresaID) {
        this.codigo_prod = codigo_prod;
        this.nome_prod = nome_prod;
        this.perco_prod = perco_prod;
        this.empresaID = empresaID;
    }

    @Column(name = "nome_prod", nullable = false, length = 100)
    private String nome_prod;

    @Column(name = "perco_prod", nullable = false)
    private Double perco_prod;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresaID;

}
