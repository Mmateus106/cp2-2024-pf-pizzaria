package br.com.fiap.pizzaria.domain.service;

import br.com.fiap.pizzaria.domain.dto.request.OpcionalRequest;
import br.com.fiap.pizzaria.domain.dto.response.OpcionalResponse;
import br.com.fiap.pizzaria.domain.entity.Opcional;
import br.com.fiap.pizzaria.domain.repository.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OpcionalService implements ServiceDTO<Opcional, OpcionalRequest, OpcionalResponse> {


    @Autowired
    private OpcionalRepository repo;

    @Override
    public Collection<Opcional> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Opcional> findAll(Example<Opcional> example) {
        return null;
    }

    @Override
    public Opcional findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Opcional save(Opcional opcional) {
        return repo.save( opcional );
    }

    @Override
    public Opcional toEntity(OpcionalRequest dto) {
        return null;
    }

    @Override
    public OpcionalResponse toResponse(Opcional e) {
        return null;
    }
}
