package com.tp3.petfriends.service;

import com.tp3.petfriends.aggregate.PedidoAggregate;
import com.tp3.petfriends.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoQueryService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoQueryService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoAggregate> obterTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoAggregate> obterPedidoPorId(String id) {
        return pedidoRepository.findById(id);
    }

}
