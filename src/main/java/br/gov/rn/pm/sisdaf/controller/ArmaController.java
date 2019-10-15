//package br.gov.rn.pm.sisdaf.controller;
//
//
//import br.gov.rn.pm.sisdaf.model.Arma;
//import br.gov.rn.pm.sisdaf.service.ArmaService;
//import br.gov.rn.pm.sisdaf.service.ModeloService;
//import br.gov.rn.pm.sisdaf.service.OpmService;
//import br.gov.rn.pm.sisdaf.service.PolicialService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/armas")
//public class ArmaController {
//
//    @Autowired
//    private ArmaService armaService;
//
//    @Autowired
//    private OpmService opmService;
//
//    @Autowired
//    private ModeloService modeloService;
//
//    @GetMapping
//    public String buscaTodos(Model model) {
//        model.addAttribute("arma", new Arma());
//        model.addAttribute("armas", armaService.buscaTodos());
//        model.addAttribute("opms", opmService.buscaTodos());
//        model.addAttribute("modelos", modeloService.buscaTodos());
//        return "arma/index";
//    }
//
//    @PostMapping
//    public String salva(Arma arma) {
//        armaService.salva(arma);
//        return "redirect:/armas";
//    }
//
//    @GetMapping("/{id}/remove")
//    public String remove(@PathVariable("id") Long id) {
//        armaService.removePorId(id);
//        return "redirect:/armas";
//    }
//
//    @GetMapping("/{id}/edita")
//    public String edita(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("arma", armaService.buscaPorId(id));
//        model.addAttribute("armas", armaService.buscaTodos());
//        model.addAttribute("opms", opmService.buscaTodos());
//        model.addAttribute("modelos", modeloService.buscaTodos());
//        return "arma/index";
//    }
//}
