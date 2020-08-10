package br.com.couto.cartoes.demo.controller;

import br.com.couto.cartoes.demo.model.PagamentoModel;
import br.com.couto.cartoes.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;


    @PostMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoModel> createPayment(@RequestBody PagamentoModel pagamentoModel) {
        PagamentoModel novoPagamentoModel = pagamentoService.createPayment(pagamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamentoModel);
    }

    @GetMapping(value = "/pagamentos/{id_cartao}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PagamentoModel>> findPaymentsByCartaoId(@PathVariable("id_cartao") Long cartaoId) {
        List<PagamentoModel> pagamentoModels = pagamentoService.findByCartaoId(cartaoId);
        return ResponseEntity.ok(pagamentoModels);
    }

}
