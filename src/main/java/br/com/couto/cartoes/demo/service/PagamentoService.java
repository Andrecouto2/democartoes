package br.com.couto.cartoes.demo.service;

import br.com.couto.cartoes.demo.Util.PagamentoWrapperUtil;
import br.com.couto.cartoes.demo.entity.Cartao;
import br.com.couto.cartoes.demo.entity.Pagamento;
import br.com.couto.cartoes.demo.exception.CustomCartaoNotFoundException;
import br.com.couto.cartoes.demo.model.PagamentoModel;
import br.com.couto.cartoes.demo.repository.CartaoRepository;
import br.com.couto.cartoes.demo.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public PagamentoModel createPayment(@Valid PagamentoModel pagamentoModel) throws CustomCartaoNotFoundException {
        Optional<Cartao> cartao = cartaoRepository.findById(pagamentoModel.getCartaoId());
        if (!cartao.isPresent()) {
            throw new CustomCartaoNotFoundException();
        }
        Pagamento pagamento = new Pagamento();
        pagamento.setCartao(cartao.get());
        pagamento.setDescricao(pagamentoModel.getDescricao());
        pagamento.setValor(pagamentoModel.getValor());

        Pagamento novoPagamento = pagamentoRepository
                .save(pagamento);
        return PagamentoWrapperUtil.unwrapperPagamentoToPagamentoModel(novoPagamento);
    }

    public List<PagamentoModel> findByCartaoId(Long cartaoId) {
        List<Pagamento> pagamentos = pagamentoRepository.findByCartaoId(cartaoId);
        return pagamentos
                .stream()
                .map(PagamentoWrapperUtil::unwrapperPagamentoToPagamentoModel)
                .collect(Collectors.toList());
    }
}