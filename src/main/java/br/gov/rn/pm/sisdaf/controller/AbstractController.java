package br.gov.rn.pm.sisdaf.controller;

import br.gov.rn.pm.sisdaf.model.AuditedEntity;
import br.gov.rn.pm.sisdaf.service.GenericService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractController<T extends AuditedEntity> {

    protected final String URL_EDITAR_PADRAO = "/{id}/edita";
    protected final String URL_REMOVER_PADRAO = "/{id}/remove";
    protected final String URL_HOME_PADRAO = getNomeEntidade().concat("/index");
    protected final String REDIRECT_HOME_PADRAO = "redirect:/".concat(getNomeEntidade());

    @Autowired
    private GenericService<T> service;

    public abstract Class<T> getClassType();

    @GetMapping
    public String buscaTodos(Model model) {
        try {
            model.addAttribute(getNomeEntidade(), getClassType().getDeclaredConstructor().newInstance());
            model.addAttribute(getNomeEntidadeLista(), service.buscaTodos());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return URL_HOME_PADRAO;
    }

    @PostMapping
    public String salva(T t) {
        service.salva(t);
        return REDIRECT_HOME_PADRAO;
    }

    @GetMapping(URL_REMOVER_PADRAO)
    public String remove(@PathVariable("id") Long id) {
        service.removePorId(id);
        return REDIRECT_HOME_PADRAO;
    }

    @GetMapping(URL_EDITAR_PADRAO)
    public String edita(@PathVariable("id") Long id, Model model) {
        model.addAttribute(getNomeEntidade(), service.buscaPorId(id));
        model.addAttribute(getNomeEntidadeLista(), service.buscaTodos());
        return URL_HOME_PADRAO;
    }

    private String getNomeEntidade() {
        return getClassType().getSimpleName().toLowerCase();
    }

    private String getNomeEntidadeLista() {
        return getNomeEntidade().concat("Lista");
    }

}
