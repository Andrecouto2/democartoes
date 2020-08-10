package br.com.couto.cartoes.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Cartao {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    private String numero;

    @Setter
    @Getter
    private Boolean ativo;

    @OneToOne
    @Getter
    @Setter
    private Cliente cliente;
}
