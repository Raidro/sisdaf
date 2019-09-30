package br.gov.rn.pm.sisdaf.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_modelos")
public class Modelo extends AuditedEntity {

    @Id
    @Column(name = "mod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mod_tipo")
    private String tipo;

    @Column(name = "mod_calibre")
    private String calibre;

    @Column(name = "mod_nome")
    private String nome;

    @Column(name = "mod_fabricante")
    private String fabricante;

}
