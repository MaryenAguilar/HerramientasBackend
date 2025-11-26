package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.OrderItem;
import com.marly.demo.Persistance.Entity.Pedido_Item;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "itemId", source = "idItem")
    @Mapping(target = "orderId", source = "pedido.idPedido")
    @Mapping(target = "productId", source = "producto.idProducto")
    @Mapping(target = "productName", source = "producto.nombre")
    @Mapping(target = "quantity", source = "cantidad")
    @Mapping(target = "unitPrice", source = "precioUnitario")
    @Mapping(target = "total", source = "total")
    OrderItem toOrderItem(Pedido_Item pedidoItem);

    List<OrderItem> toOrderItems(List<Pedido_Item> items);

    // DTO -> Entity
    @Mapping(target = "idItem", source = "itemId")
    @Mapping(target = "cantidad", source = "quantity")
    @Mapping(target = "precioUnitario", source = "unitPrice")
    @Mapping(target = "total", source = "total")
    // estos lo asignamos manualmente en repository
    @Mapping(target = "pedido", ignore = true)
    @Mapping(target = "producto", ignore = true)
    Pedido_Item toPedidoItem(OrderItem orderItem);
}
