package br.com.couto.cartoes.demo.controller;

import br.com.couto.cartoes.demo.model.PagamentoModel;
import br.com.couto.cartoes.demo.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @RequestMapping("/pagamento")
    @PostMapping()
    public ResponseEntity<PagamentoModel> createPayment(PagamentoModel pagamentoModel) {
        PagamentoModel novoPagamentoModel = pagamentoService.createPayment(pagamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPagamentoModel);
    }

    @RequestMapping("/pagamentos")
    @GetMapping(path = {"{id_cartao}"})
    public ResponseEntity<List<PagamentoModel>> findPaymentsByCartaoId(@PathVariable("id_cartao") Long cartaoId) {
        List<PagamentoModel> pagamentoModels = pagamentoService.findByCartaoId(cartaoId);
        return ResponseEntity.ok(pagamentoModels);
    }

}
