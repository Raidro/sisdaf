package br.gov.rn.pm.sisdaf.resource;

import br.gov.rn.pm.sisdaf.model.Policial;
import br.gov.rn.pm.sisdaf.service.PolicialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/policiais")
public class PolicialResource {

    @Autowired
    private PolicialService service;

    @GetMapping
    public List<Policial> findAll(){return service.buscaTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Policial> findById(@PathVariable("id") Long id){

        try{
            Policial policial = service.buscaPorId(id);
            return ResponseEntity.ok(policial);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Policial> cria(@RequestBody Policial policial, HttpServletResponse response){
        Policial c = service.salva(policial);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(c.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
