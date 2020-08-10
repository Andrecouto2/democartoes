package br.com.couto.cartoes.demo.controller;

import br.com.couto.cartoes.demo.model.CartaoModel;
import br.com.couto.cartoes.demo.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping()
    public ResponseEntity<CartaoModel> save(@RequestBody CartaoModel cartaoModel) {
        CartaoModel novoCartao = cartaoService.createCard(cartaoModel.getNumero(), cartaoModel.getClienteId());
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCartao);
    }

    @PatchMapping(path = {"{numero}"})
    public ResponseEntity<CartaoModel> enableAndDisableCard(@RequestBody CartaoModel cartaoModel, @PathVariable("numero") String numero) {
        CartaoModel cartaoModelUpdated = cartaoService.enableAndDisableCard(numero, cartaoModel.getAtivo());
        return ResponseEntity.ok(cartaoModelUpdated);
    }

    @GetMapping(path = {"{numero}"})
    public ResponseEntity<CartaoModel> findByNumero(@PathVariable("numero") String numero) {
        CartaoModel cartaoModelUpdated = cartaoService.findByNumero(numero);
        return ResponseEntity.ok(cartaoModelUpdated);
    }

}
