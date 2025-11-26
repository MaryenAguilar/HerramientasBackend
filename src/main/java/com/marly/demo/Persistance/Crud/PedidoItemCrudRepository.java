package com.marly.demo.Persistance.Crud;

import com.marly.demo.Persistance.Entity.Pedido_Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoItemCrudRepository extends CrudRepository<Pedido_Item, Integer> {
    List<Pedido_Item> findByPedidoIdPedido(Integer idPedido);
}
