package br.gov.rn.pm.sisdaf.controller;

import br.gov.rn.pm.sisdaf.model.Arma;
import br.gov.rn.pm.sisdaf.model.Ocorrencia;
import br.gov.rn.pm.sisdaf.model.Policial;
import br.gov.rn.pm.sisdaf.service.ArmaService;
import br.gov.rn.pm.sisdaf.service.OcorrenciaService;
import br.gov.rn.pm.sisdaf.service.OpmService;
import br.gov.rn.pm.sisdaf.service.PolicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private PolicialService policialService;

    @Autowired
    private OpmService opmService;

    @Autowired
    private ArmaService armaService;

    @GetMapping
    public String buscaTodos(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("ocorrencias", ocorrenciaService.buscaTodos());
        model.addAttribute("opms", opmService.buscaTodos());
        model.addAttribute("policiais", policialService.buscaTodos());
        model.addAttribute("armas", armaService.buscaTodos());
        return "ocorrencia/index";
    }

    @PostMapping
    public String salva(Ocorrencia ocorrencia) {
        ocorrenciaService.salva(ocorrencia);
        return "redirect:/ocorrencias";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        ocorrenciaService.removePorId(id);
        return "redirect:/ocorrencias";
    }

    @GetMapping("/{id}/edita")
    public String edita(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ocorrencia", ocorrenciaService.buscaPorId(id));
        model.addAttribute("ocorrencias", ocorrenciaService.buscaTodos());
        model.addAttribute("opms", opmService.buscaTodos());
        model.addAttribute("policiais", policialService.buscaTodos());
        model.addAttribute("armas", armaService.buscaTodos());
        return "ocorrencia/index";
    }

}
