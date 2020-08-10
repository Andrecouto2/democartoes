package br.com.couto.cartoes.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "cartao_id")
    private Long cartaoId;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "valor")
    private Double valor;
}
