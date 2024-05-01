package br.com.fiap.pizzaria.domain.resource;

import br.com.fiap.pizzaria.domain.dto.response.OpcionalResponse;
import br.com.fiap.pizzaria.domain.entity.Opcional;
import br.com.fiap.pizzaria.domain.service.OpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/opcionais")
public class OpcionalResource {

    @Autowired
    private OpcionalService service;

    @GetMapping
    public Collection<Opcional> findAll(Example<Opcional> example) {
        return service.findAll( example );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OpcionalResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById( id );
        var resposta = service.toResponse( encontrado );
        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    public Opcional save(@RequestBody Opcional opcional) {
        return service.save(opcional);

    }
}
