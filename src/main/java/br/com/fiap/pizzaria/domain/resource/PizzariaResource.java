package br.com.fiap.pizzaria.domain.resource;

import br.com.fiap.pizzaria.domain.dto.request.PizzariaRequest;
import br.com.fiap.pizzaria.domain.dto.response.PizzariaResponse;
import br.com.fiap.pizzaria.domain.entity.Pizzaria;
import br.com.fiap.pizzaria.domain.service.PizzariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(name = "/pizzarias")
public class PizzariaResource {

    @Autowired
    private PizzariaService service;

    @GetMapping
    public Collection<Pizzaria> findAll(Example<Pizzaria> example) {
        return service.findAll( example );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PizzariaResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById( id );
        var resposta = service.toResponse( encontrado );
        return ResponseEntity.ok( resposta );
    }

//    @Transactional
    @PostMapping
    public Pizzaria save(@RequestBody PizzariaRequest pizzariaRequest) {
        var pizzaria = service.toEntity(pizzariaRequest);
        return service.save(pizzaria);

    }


    //"logalhost/pizzarias/{id}/cardapio" - POST


    //"localhost/pizzarias/{id}/cardapio" - GET

}
