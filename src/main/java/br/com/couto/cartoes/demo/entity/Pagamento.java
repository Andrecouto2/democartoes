package br.com.couto.cartoes.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Pagamento {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    private String descricao;

    @Setter
    @Getter
    private Double valor;

    @OneToOne
    @Getter
    @Setter
    private Cartao cartao;
}
