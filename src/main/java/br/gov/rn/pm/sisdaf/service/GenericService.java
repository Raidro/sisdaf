package br.gov.rn.pm.sisdaf.service;

import br.gov.rn.pm.sisdaf.model.AuditedEntity;
import br.gov.rn.pm.sisdaf.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class GenericService<T extends AuditedEntity> {

    @Autowired
    private GenericRepository<T> repository;

    public List<T> buscaTodos() {
        return repository.findAll();
    }

    public T buscaPorId(Long id) {
        return repository.findById(id).get();
    }

    public void salva(T t){
        repository.save(t);
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }

}
