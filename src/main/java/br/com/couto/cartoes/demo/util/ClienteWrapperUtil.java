package br.com.couto.cartoes.demo.util;

import br.com.couto.cartoes.demo.entity.Cliente;
import br.com.couto.cartoes.demo.model.ClienteModel;

public class ClienteWrapperUtil {

    public static ClienteModel unwrapperClienteToClienteModel(Cliente cliente) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(cliente.getId());
        clienteModel.setNome(cliente.getNome());
        return clienteModel;
    }

    public static Cliente unwrapperClienteModelToCliente(ClienteModel clienteModel) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteModel.getId());
        cliente.setNome(clienteModel.getNome());
        return cliente;
    }
}
