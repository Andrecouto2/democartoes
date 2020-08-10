package br.com.couto.cartoes.demo.service;

import br.com.couto.cartoes.demo.Util.ClienteWrapperUtil;
import br.com.couto.cartoes.demo.entity.Cliente;
import br.com.couto.cartoes.demo.exception.CustomClienteNotFoundException;
import br.com.couto.cartoes.demo.model.ClienteModel;
import br.com.couto.cartoes.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteModel save(ClienteModel clienteModel) {
        Cliente novoCliente = repository.save(ClienteWrapperUtil.unwrapperClienteModelToCliente(clienteModel));
        return ClienteWrapperUtil.unwrapperClienteToClienteModel(novoCliente);
    }

    public ClienteModel findById(Long clientId) throws CustomClienteNotFoundException {
        Optional<Cliente> cliente = repository.findById(clientId);
        if (cliente.isPresent()) {
            return ClienteWrapperUtil.unwrapperClienteToClienteModel(cliente.get());
        } else {
            throw new CustomClienteNotFoundException();
        }
    }
}
