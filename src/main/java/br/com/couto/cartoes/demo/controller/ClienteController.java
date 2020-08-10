package br.com.couto.cartoes.demo.controller;

import br.com.couto.cartoes.demo.model.ClienteModel;
import br.com.couto.cartoes.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = {"{id}"})
    public ResponseEntity<ClienteModel> findById(@PathVariable("id") Long clienteId) {
        return ResponseEntity.ok(clienteService.findById(clienteId));
    }

    @PostMapping()
    public ResponseEntity<ClienteModel> save(@RequestBody ClienteModel clienteModel) {
        ClienteModel novoCliente = clienteService.save(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

}
