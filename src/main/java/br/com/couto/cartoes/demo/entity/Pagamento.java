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
@Table(name = "pagamento")
public class Pagamento {

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
    private String descricao;

    @Setter
    @Getter
    @Column
    private Double valor;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "cartao_id", referencedColumnName = "id")
    private Cartao cartao;
}
