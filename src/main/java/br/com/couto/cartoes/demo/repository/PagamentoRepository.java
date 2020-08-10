package br.com.couto.cartoes.demo.repository;

import br.com.couto.cartoes.demo.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCartaoId(Long cartaoId);
}
