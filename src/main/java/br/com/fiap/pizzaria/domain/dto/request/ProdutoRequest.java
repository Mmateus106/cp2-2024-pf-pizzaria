package br.com.fiap.pizzaria.domain.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotNull(message = "Nome do produto obrigatório")
        String nome,
        AbstractRequest sabor,
        BigDecimal preco
) {
}
