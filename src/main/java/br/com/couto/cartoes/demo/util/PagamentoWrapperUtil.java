package br.com.couto.cartoes.demo.util;

import br.com.couto.cartoes.demo.entity.Cartao;
import br.com.couto.cartoes.demo.entity.Pagamento;
import br.com.couto.cartoes.demo.model.PagamentoModel;

public class PagamentoWrapperUtil {

    public static PagamentoModel unwrapperPagamentoToPagamentoModel(Pagamento pagamento) {
        PagamentoModel pagamentoModel = new PagamentoModel();
        pagamentoModel.setId(pagamento.getId());
        pagamentoModel.setDescricao(pagamento.getDescricao());
        pagamentoModel.setValor(pagamento.getValor());
        pagamentoModel.setCartaoId(pagamento.getCartao().getId());
        return pagamentoModel;
    }

    public static Pagamento unwrapperPagamentoModelToPagamento(PagamentoModel pagamentoModel) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoModel.getId());
        pagamento.setDescricao(pagamentoModel.getDescricao());
        pagamento.setValor(pagamentoModel.getValor());
        Cartao cartao = new Cartao();
        cartao.setId(pagamentoModel.getCartaoId());
        pagamento.setCartao(cartao);
        return pagamento;
    }
}
