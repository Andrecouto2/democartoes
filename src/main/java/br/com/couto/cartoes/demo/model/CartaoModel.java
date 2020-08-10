package br.com.couto.cartoes.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoModel {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "numero")
    private String numero;

    @JsonProperty(value = "clienteId")
    private Long clienteId;

    @JsonProperty(value = "ativo")
    private Boolean ativo;
}
