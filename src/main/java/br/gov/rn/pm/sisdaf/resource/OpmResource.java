package br.gov.rn.pm.sisdaf.resource;

import br.gov.rn.pm.sisdaf.model.AuditedEntity;
import br.gov.rn.pm.sisdaf.model.Opm;
import br.gov.rn.pm.sisdaf.service.OpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/opms")
public class OpmResource  {

    @Autowired
    private OpmService service;

    @GetMapping
    public List<Opm> findAll(){return service.buscaTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Opm> findById(@PathVariable("id") Long id){

        try{
            Opm opm = service.buscaPorId(id);
            return ResponseEntity.ok(opm);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Opm> cria(@RequestBody Opm opm, HttpServletResponse response){
        Opm c = service.salva(opm);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(c.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
