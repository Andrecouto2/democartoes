package br.com.couto.cartoes.demo.Util;

import br.com.couto.cartoes.demo.entity.Cartao;
import br.com.couto.cartoes.demo.entity.Cliente;
import br.com.couto.cartoes.demo.model.CartaoModel;

public class CartaoWrapperUtil {

    public static CartaoModel unwrapperCartaoToCartaoModel(Cartao cartao) {
        CartaoModel cartaoModel = new CartaoModel();
        cartaoModel.setId(cartao.getId());
        cartaoModel.setNumero(cartao.getNumero());
        cartaoModel.setClienteId(cartao.getCliente().getId());
        cartaoModel.setAtivo(cartao.getAtivo());
        return cartaoModel;
    }

    public static Cartao unwrapperCartaoModelToCartao(CartaoModel cartaoModel) {
        Cartao cartao = new Cartao();
        Cliente cliente = new Cliente();
        cliente.setId(cartaoModel.getClienteId());
        cartao.setId(cartaoModel.getId());
        cartao.setNumero(cartao.getNumero());
        cartao.setAtivo(cartao.getAtivo());
        cartao.setCliente(cliente);
        return cartao;
    }
}
