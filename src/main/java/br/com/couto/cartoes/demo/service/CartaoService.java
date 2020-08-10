package br.com.couto.cartoes.demo.service;

import br.com.couto.cartoes.demo.util.CartaoWrapperUtil;
import br.com.couto.cartoes.demo.entity.Cartao;
import br.com.couto.cartoes.demo.entity.Cliente;
import br.com.couto.cartoes.demo.exception.CustomCartaoNotFoundException;
import br.com.couto.cartoes.demo.exception.CustomClienteNotFoundException;
import br.com.couto.cartoes.demo.model.CartaoModel;
import br.com.couto.cartoes.demo.repository.CartaoRepository;
import br.com.couto.cartoes.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public CartaoModel createCard(String numero, Long clientId) throws CustomClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(clientId);
        if (!cliente.isPresent()) {
            throw new CustomClienteNotFoundException();
        }

        Cartao cartao = new Cartao();
        cartao.setNumero(numero);
        cartao.setCliente(cliente.get());

        return CartaoWrapperUtil.unwrapperCartaoToCartaoModel(cartaoRepository.save(cartao));
    }

    public CartaoModel enableAndDisableCard(String numero, Boolean ativo) throws CustomCartaoNotFoundException {
        Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
        if (!cartao.isPresent()) {
            throw new CustomCartaoNotFoundException();
        }
        cartao.get().setAtivo(ativo);
        return CartaoWrapperUtil.unwrapperCartaoToCartaoModel(cartaoRepository.saveAndFlush(cartao.get()));
    }

    public CartaoModel findByNumero(String numero) throws CustomCartaoNotFoundException {
        Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
        if (!cartao.isPresent()) {
            throw new CustomCartaoNotFoundException();
        }
        cartao.get().setAtivo(null);
        return CartaoWrapperUtil.unwrapperCartaoToCartaoModel(cartao.get());
    }
}
