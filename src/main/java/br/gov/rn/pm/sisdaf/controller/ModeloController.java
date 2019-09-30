package br.gov.rn.pm.sisdaf.controller;

import br.gov.rn.pm.sisdaf.model.Modelo;
import br.gov.rn.pm.sisdaf.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modelos")
public class ModeloController{

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public String buscaTodos(Model model) {
        model.addAttribute("modelo", new Modelo());
        model.addAttribute("modelos", modeloService.buscaTodos());
        return "modelo/index";
    }

    @PostMapping
    public String salva(Modelo modelo) {
        modeloService.salva(modelo);
        return "redirect:/modelos";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
       modeloService.removePorId(id);
        return "redirect:/modelos";
    }

    @GetMapping("/{id}/edita")
    public String edita(@PathVariable("id") Long id, Model model) {
        model.addAttribute("modelo", modeloService.buscaPorId(id));
        model.addAttribute("modelos", modeloService.buscaTodos());
        return "modelo/index";
    }


}
