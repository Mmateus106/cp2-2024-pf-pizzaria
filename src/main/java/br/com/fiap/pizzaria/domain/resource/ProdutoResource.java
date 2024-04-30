package br.com.fiap.pizzaria.domain.resource;

import br.com.fiap.pizzaria.domain.dto.response.ProdutoResponse;
import br.com.fiap.pizzaria.domain.entity.Opcional;
import br.com.fiap.pizzaria.domain.entity.Produto;
import br.com.fiap.pizzaria.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(name = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public Collection<Produto> findAll(Example<Produto> example) {
        return service.findAll( example );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        var encontrado = service.findById( id );
        var resposta = service.toResponse( encontrado );
        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return service.save(produto);

    }


    //"localhost/produtos/{id}/opcionais" - POST

    @PostMapping("/{id}/opcionais")
    public ResponseEntity<String> adicionarOpcionais(@PathVariable Long id, @RequestBody Collection<Opcional> opcionais) {
        Produto produto = service.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produto.getOpcionais().addAll(opcionais);
        service.save(produto);
        return ResponseEntity.ok("Opcionais adicionados com sucesso ao produto de ID: " + id);
    }

    //"localhost/produtos/{id}/opcionais" - GET

    @GetMapping("/{id}/opcionais")
    public ResponseEntity<Collection<Opcional>> getOpcionais(@PathVariable Long id) {
        Produto produto = service.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        Collection<Opcional> opcionais = produto.getOpcionais();
        return ResponseEntity.ok(opcionais);
    }

}
