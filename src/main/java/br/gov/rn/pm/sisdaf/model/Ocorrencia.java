package br.gov.rn.pm.sisdaf.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Data
@Entity
@Table(name="tb_ocorrencias")
public class Ocorrencia extends AuditedEntity {

    @Id
    @Column(name="oco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name="oco_data")
//    private Date data;
//
//    @Column(name="oco_hora")
//    private Time hora;

    @Column(name="oco_data")
    private String data;

    @Column(name="oco_hora")
    private String hora;

    @Column(name="oco_local")
    private String local;

    @Column(name="oco_quantidade")
    private Long quantidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oco_opm_id")
    private Opm opm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oco_pol_id")
    private Policial policial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oco_arm_id")
    private Arma arma;

}
