//package br.gov.rn.pm.sisdaf.controller;
//
//import br.gov.rn.pm.sisdaf.model.Policial;
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
//@RequestMapping("/policiais")
//public class PolicialController {
//
//    @Autowired
//    private PolicialService policialService;
//
//    @Autowired
//    private OpmService opmService;
//
//    @GetMapping
//    public String buscaTodos(Model model) {
//        model.addAttribute("policial", new Policial());
//        model.addAttribute("policiais", policialService.buscaTodos());
//        model.addAttribute("opms", opmService.buscaTodos());
//        return "policial/index";
//    }
//
//    @PostMapping
//    public String salva(Policial policial) {
//        policialService.salva(policial);
//        return "redirect:/policiais";
//    }
//
//    @GetMapping("/{id}/remove")
//    public String remove(@PathVariable("id") Long id) {
//        policialService.removePorId(id);
//        return "redirect:/policiais";
//    }
//
//    @GetMapping("/{id}/edita")
//    public String edita(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("policial", policialService.buscaPorId(id));
//        model.addAttribute("policiais", policialService.buscaTodos());
//        model.addAttribute("opms", opmService.buscaTodos());
//        return "policial/index";
//    }
//
//}
