package br.gov.rn.pm.sisdaf.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditedEntity implements PersistableEntity<Long> {

    @CreatedDate
    @Column(name="DATA_CRIACAO", nullable = true, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATA_MODIFICACAO")
    private Date dataModificacao;

    @Column
    private Boolean ativo = true;

    @PreUpdate
    public void preUpdate() {
        this.dataModificacao = new Date();
    }

}
