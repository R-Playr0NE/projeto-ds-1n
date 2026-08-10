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
@Table(name = "tb_funcionario")
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionario;

    public Funcionario(Long id_funcionario, String nome_funcionario, String cargo_funcionario,
            Double salario_funcionario, Empresa empresaID) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.cargo_funcionario = cargo_funcionario;
        this.salario_funcionario = salario_funcionario;
        this.empresaID = empresaID;
    }

    @Column(name = "nome_funcionario", nullable = false, length = 100)
    private String nome_funcionario;

    @Column(name = "cargo_funcionario", nullable = false, length = 100)
    private String cargo_funcionario;

    @Column(name = "salario_funcionario", nullable = false)
    private Double salario_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresaID;

}
