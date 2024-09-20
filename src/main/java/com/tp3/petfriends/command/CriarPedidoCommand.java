package com.tp3.petfriends.command;

public class CriarPedidoCommand extends BaseCommand<String> {

    private final String clienteId;
    private final String descricao;
    private final double valor;

    public CriarPedidoCommand(String id, String clienteId, String descricao, double valor) {
        super(id);
        this.clienteId = clienteId;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
