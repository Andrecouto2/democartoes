package br.com.couto.cartoes.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    @JsonProperty(value = "id")
    private Long id;

    @NotNull
    @JsonProperty(value = "name")
    private String nome;
}
