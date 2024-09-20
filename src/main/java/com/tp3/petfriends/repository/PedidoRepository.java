package com.tp3.petfriends.repository;

import com.tp3.petfriends.aggregate.PedidoAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoAggregate, String> {
}
