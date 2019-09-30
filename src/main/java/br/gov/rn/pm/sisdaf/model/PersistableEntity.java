package br.gov.rn.pm.sisdaf.model;

import java.io.Serializable;

public interface PersistableEntity<PK extends Serializable> {

    PK getId();

    void setId(PK id);

}
