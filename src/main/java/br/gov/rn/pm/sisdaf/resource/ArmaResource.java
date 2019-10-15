package br.gov.rn.pm.sisdaf.resource;

import br.gov.rn.pm.sisdaf.model.Arma;
import br.gov.rn.pm.sisdaf.service.ArmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/armas")
public class ArmaResource {

    @Autowired
    private ArmaService service;

    @GetMapping
    public List<Arma> findAll(){return service.buscaTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Arma> findById(@PathVariable("id") Long id){

        try{
            Arma arma = service.buscaPorId(id);
            return ResponseEntity.ok(arma);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Arma> cria(@RequestBody Arma arma, HttpServletResponse response){
        Arma c = service.salva(arma);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(c.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
