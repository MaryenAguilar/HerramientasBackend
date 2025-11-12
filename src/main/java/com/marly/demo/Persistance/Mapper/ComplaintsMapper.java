package com.marly.demo.Persistance.Mapper;

import com.marly.demo.Domain.Complaints;
import com.marly.demo.Persistance.Entity.Reclamos;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ComplaintsMapper {
    @Mappings({
            @Mapping(source = "idreclamo", target = "idcomplaints"),
            @Mapping(source = "fechapedido", target = "orderdate"),
            @Mapping(source = "motivoreclamo", target = "claimreason"),
            @Mapping(source = "detalle", target = "detail"),
            @Mapping(source = "estadoreclamo", target = "claimstatus"),
            @Mapping(source = "fechareclamo", target = "claimdate"),
            @Mapping(source = "usuario.id", target = "userId")
    })
    Complaints toComplaints(Reclamos reclamos);

    List<Complaints> toComplaintsList(List<Reclamos> reclamosList);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true) // Se ignora para evitar bucles o dependencias circulares
    Reclamos toReclamos(Complaints complaints);
}
