package br.com.fiap.pizzaria.domain.dto.request;

import br.com.fiap.pizzaria.domain.entity.Produto;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PizzariaRequest(

        @NotNull(message = "O nome da pizzaria é obrigatório")
        String nome,
        Set<Produto> cardapio
) {
}
