package br.gov.rn.pm.sisdaf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_opms")
public class Opm extends AuditedEntity {

    @Id
    @Column(name = "opm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opm_nome")
    private String nome;

    @Column(name = "opm_sigla")
    private String sigla;

}
