package com.tp3.petfriends.controller;

import com.tp3.petfriends.dto.CriarPedidoRequest;
import com.tp3.petfriends.service.PedidoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService pedidoCommandService;

    @Autowired
    public PedidoCommandController(PedidoCommandService pedidoCommandService) {
        this.pedidoCommandService = pedidoCommandService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> criarPedido(@RequestBody CriarPedidoRequest request) {
        return pedidoCommandService
                .criarPedido(request.getId(), request.getClienteId(), request.getDescricao(), request.getValor())
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> ResponseEntity.badRequest().body(e.getMessage()));
    }

}
