package br.com.fiap.pizzaria.domain.resource;

import br.com.fiap.pizzaria.domain.dto.response.SaborResponse;
import br.com.fiap.pizzaria.domain.entity.Sabor;
import br.com.fiap.pizzaria.domain.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/sabores")
public class SaborResource {

    @Autowired
    private SaborService service;

    @GetMapping
    public Collection<Sabor> findAll(Example<Sabor> example) {
        return service.findAll( example );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaborResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById( id );
        var resposta = service.toResponse( encontrado );
        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    public Sabor save(@RequestBody Sabor sabor) {
        return service.save(sabor);

    }
}
