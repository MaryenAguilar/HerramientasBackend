package com.marly.demo.Persistance.Crud;

import com.marly.demo.Persistance.Entity.Pedido;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PedidoCrudRepository extends CrudRepository<Pedido, Integer> {
    List<Pedido> findByUsuario_Id(Integer idUsuario);
}
