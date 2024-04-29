package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.ProdutoRequest;
import br.com.fiap.pizzaria.domain.dto.response.ProdutoResponse;
import br.com.fiap.pizzaria.domain.entity.Produto;
import br.com.fiap.pizzaria.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse>{

    @Autowired
    private ProdutoRepository repo;


    @Override
    public Collection<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Produto> findAll(Example<Produto> example) {
        return repo.findAll( example );
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Produto save(Produto produto) {
        return repo.save( produto );
    }

    @Override
    public Produto toEntity(ProdutoRequest dto) {
        return null;
    }

    @Override
    public ProdutoResponse toResponse(Produto e) {
        return null;
    }
}
