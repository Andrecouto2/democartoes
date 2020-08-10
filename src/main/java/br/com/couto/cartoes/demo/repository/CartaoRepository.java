package br.com.couto.cartoes.demo.repository;

import br.com.couto.cartoes.demo.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findByNumero(String numero);
}
