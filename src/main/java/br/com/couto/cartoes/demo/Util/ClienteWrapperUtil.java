package br.com.couto.cartoes.demo.Util;

import br.com.couto.cartoes.demo.entity.Cliente;
import br.com.couto.cartoes.demo.model.ClienteModel;

public class ClienteWrapperUtil {

    public static ClienteModel unwrapperClienteToClienteModel(Cliente cliente) {
        ClienteModel clienteModel = new ClienteModel();
        cliente.setId(cliente.getId());
        cliente.setNome(cliente.getNome());
        return clienteModel;
    }

    public static Cliente unwrapperClienteModelToCliente(ClienteModel clienteModel) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteModel.getId());
        cliente.setNome(clienteModel.getNome());
        return cliente;
    }
}
