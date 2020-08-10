package br.com.couto.cartoes.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartao")
public class Cartao {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "id", nullable = false, unique = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Setter
    @Getter
    @Column
    private String numero;

    @Setter
    @Getter
    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean ativo;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Cliente cliente;

    @PrePersist
    protected void onCreate() {
        ativo = false;
    }
}
