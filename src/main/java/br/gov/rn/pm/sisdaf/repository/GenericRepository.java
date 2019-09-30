package br.gov.rn.pm.sisdaf.repository;

import br.gov.rn.pm.sisdaf.model.AuditedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T extends AuditedEntity> extends JpaRepository<T, Long> {




}
