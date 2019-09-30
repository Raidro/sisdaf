package br.gov.rn.pm.sisdaf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_policiais")
public class Policial extends AuditedEntity {

    @Id
    @Column(name = "pol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pol_nome")
    private String nome;

    @Column(name = "pol_matricula", unique = true)
    private String matricula;

    @Column(name="pol_cpf")
    private String cpf;

    @Column(name="pol_cargo")
    private String cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pol_opm_id")
    private Opm opm;

}
