package com.tp3.petfriends.service;

import com.tp3.petfriends.command.CriarPedidoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {

    private final CommandGateway commandGateway;

    @Autowired
    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(String id, String clienteId, String descricao, double valor) {
        CriarPedidoCommand command = new CriarPedidoCommand(id, clienteId, descricao, valor);
        return commandGateway.send(command);
    }
}
