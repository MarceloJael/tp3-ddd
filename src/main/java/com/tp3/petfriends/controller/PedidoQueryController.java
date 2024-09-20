package com.tp3.petfriends.controller;

import com.tp3.petfriends.aggregate.PedidoAggregate;
import com.tp3.petfriends.service.PedidoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    @Autowired
    public PedidoQueryController(PedidoQueryService pedidoQueryService) {
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoAggregate>> listarTodosPedidos() {
        return ResponseEntity.ok(pedidoQueryService.obterTodosPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoAggregate> obterPedidoPorId(@PathVariable String id) {
        return pedidoQueryService.obterPedidoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
