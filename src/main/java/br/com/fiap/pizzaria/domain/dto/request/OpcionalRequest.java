package br.com.fiap.pizzaria.domain.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OpcionalRequest(

        @NotNull(message = "Nome do opcional obrigatório")
        String nome,
        AbstractRequest sabor,
        BigDecimal preco
) {
}
