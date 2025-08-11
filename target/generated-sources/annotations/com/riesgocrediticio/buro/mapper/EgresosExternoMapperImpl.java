package com.riesgocrediticio.buro.mapper;

import com.riesgocrediticio.buro.dto.EgresosExternoCreateDto;
import com.riesgocrediticio.buro.dto.EgresosExternoDto;
import com.riesgocrediticio.buro.dto.EgresosExternoUpdateDto;
import com.riesgocrediticio.buro.model.EgresosExterno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T19:23:35-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class EgresosExternoMapperImpl implements EgresosExternoMapper {

    @Override
    public EgresosExterno toEntity(EgresosExternoCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        EgresosExterno egresosExterno = new EgresosExterno();

        egresosExterno.setCedulaCliente( createDto.getCedulaCliente() );
        egresosExterno.setNombres( createDto.getNombres() );
        egresosExterno.setInstitucionBancaria( createDto.getInstitucionBancaria() );
        egresosExterno.setProducto( createDto.getProducto() );
        egresosExterno.setSaldoPendiente( createDto.getSaldoPendiente() );
        egresosExterno.setMesesPendientes( createDto.getMesesPendientes() );
        egresosExterno.setCuotaPago( createDto.getCuotaPago() );
        egresosExterno.setMora( createDto.getMora() );
        egresosExterno.setMoraUltimosTresMeses( createDto.getMoraUltimosTresMeses() );

        return egresosExterno;
    }

    @Override
    public void updateEntity(EgresosExterno entity, EgresosExternoUpdateDto updateDto) {
        if ( updateDto == null ) {
            return;
        }

        if ( updateDto.getInstitucionBancaria() != null ) {
            entity.setInstitucionBancaria( updateDto.getInstitucionBancaria() );
        }
        if ( updateDto.getProducto() != null ) {
            entity.setProducto( updateDto.getProducto() );
        }
        if ( updateDto.getSaldoPendiente() != null ) {
            entity.setSaldoPendiente( updateDto.getSaldoPendiente() );
        }
        if ( updateDto.getMesesPendientes() != null ) {
            entity.setMesesPendientes( updateDto.getMesesPendientes() );
        }
        if ( updateDto.getCuotaPago() != null ) {
            entity.setCuotaPago( updateDto.getCuotaPago() );
        }
        if ( updateDto.getMora() != null ) {
            entity.setMora( updateDto.getMora() );
        }
        if ( updateDto.getMoraUltimosTresMeses() != null ) {
            entity.setMoraUltimosTresMeses( updateDto.getMoraUltimosTresMeses() );
        }
    }

    @Override
    public EgresosExternoDto toDto(EgresosExterno entity) {
        if ( entity == null ) {
            return null;
        }

        EgresosExternoDto.EgresosExternoDtoBuilder egresosExternoDto = EgresosExternoDto.builder();

        egresosExternoDto.cedulaCliente( entity.getCedulaCliente() );
        egresosExternoDto.cuotaPago( entity.getCuotaPago() );
        egresosExternoDto.fechaActualizacion( entity.getFechaActualizacion() );
        egresosExternoDto.fechaRegistro( entity.getFechaRegistro() );
        egresosExternoDto.id( entity.getId() );
        egresosExternoDto.institucionBancaria( entity.getInstitucionBancaria() );
        egresosExternoDto.mesesPendientes( entity.getMesesPendientes() );
        egresosExternoDto.mora( entity.getMora() );
        egresosExternoDto.moraUltimosTresMeses( entity.getMoraUltimosTresMeses() );
        egresosExternoDto.nombres( entity.getNombres() );
        egresosExternoDto.producto( entity.getProducto() );
        egresosExternoDto.saldoPendiente( entity.getSaldoPendiente() );
        egresosExternoDto.version( entity.getVersion() );

        return egresosExternoDto.build();
    }

    @Override
    public List<EgresosExternoDto> toDtoList(List<EgresosExterno> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EgresosExternoDto> list = new ArrayList<EgresosExternoDto>( entities.size() );
        for ( EgresosExterno egresosExterno : entities ) {
            list.add( toDto( egresosExterno ) );
        }

        return list;
    }
}
