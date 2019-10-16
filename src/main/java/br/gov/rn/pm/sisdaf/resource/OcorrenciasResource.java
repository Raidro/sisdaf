package br.gov.rn.pm.sisdaf.resource;

import br.gov.rn.pm.sisdaf.model.Ocorrencia;
import br.gov.rn.pm.sisdaf.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciasResource {

    @Autowired
    private OcorrenciaService service;

    @GetMapping
    public List<Ocorrencia> findAll(){return service.buscaTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> findById(@PathVariable("id") Long id){

        try{
            Ocorrencia ocorrencia = service.buscaPorId(id);
            return ResponseEntity.ok(ocorrencia);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> cria(@RequestBody Ocorrencia ocorrencia, HttpServletResponse response){
        Ocorrencia c = service.salva(ocorrencia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(c.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
