package br.gov.rn.pm.sisdaf.resource;

import br.gov.rn.pm.sisdaf.model.Modelo;
import br.gov.rn.pm.sisdaf.service.ModeloService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloResource {

    @Autowired
    private ModeloService service;

    @GetMapping
    public List<Modelo>findAll(){return service.buscaTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable("id") Long id){
        try{
            Modelo modelo = service.buscaPorId(id);
            return ResponseEntity.ok(modelo);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Modelo> cria(@RequestBody Modelo modelo, HttpServletResponse response){
        Modelo c = service.salva(modelo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(c.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
