package com.tp3.petfriends.aggregate;

import com.tp3.petfriends.command.CriarPedidoCommand;
import com.tp3.petfriends.event.PedidoCriadoEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import com.tp3.petfriends.event.PedidoCriadoEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PedidoAggregate {

    @AggregateIdentifier
    private String id;
    private String clienteId;
    private String descricao;
    private double valor;

    public PedidoAggregate() {

    }

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {
        apply(new PedidoCriadoEvent(command.getId(), command.getClienteId(), command.getDescricao(), command.getValor()));
    }

    @EventSourcingHandler
    protected void on(PedidoCriadoEvent event) {
        this.id = event.getId();
        this.clienteId = event.getClienteId();
        this.descricao = event.getDescricao();
        this.valor = event.getValor();
    }
}