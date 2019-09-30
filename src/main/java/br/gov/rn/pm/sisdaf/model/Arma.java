package br.gov.rn.pm.sisdaf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="tb_armas")
public class Arma extends AuditedEntity{

    @Id
    @Column(name = "arm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="arm_serial", unique = true)
    private Long serial;

    @Column(name="arm_tombamento", unique = true)
    private String tombamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arm_opm_id")
    private Opm opm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arm_mod_id")
    private Modelo modelo;
}
