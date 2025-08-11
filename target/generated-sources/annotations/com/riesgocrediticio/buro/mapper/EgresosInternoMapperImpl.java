package com.riesgocrediticio.buro.mapper;

import com.riesgocrediticio.buro.dto.EgresosInternoCreateDto;
import com.riesgocrediticio.buro.dto.EgresosInternoDto;
import com.riesgocrediticio.buro.dto.EgresosInternoUpdateDto;
import com.riesgocrediticio.buro.model.EgresosInterno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T21:20:54-0500",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class EgresosInternoMapperImpl implements EgresosInternoMapper {

    @Override
    public EgresosInterno toEntity(EgresosInternoCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        EgresosInterno egresosInterno = new EgresosInterno();

        egresosInterno.setCedulaCliente( createDto.getCedulaCliente() );
        egresosInterno.setNombres( createDto.getNombres() );
        egresosInterno.setInstitucionBancaria( createDto.getInstitucionBancaria() );
        egresosInterno.setProducto( createDto.getProducto() );
        egresosInterno.setSaldoPendiente( createDto.getSaldoPendiente() );
        egresosInterno.setMesesPendientes( createDto.getMesesPendientes() );
        egresosInterno.setCuotaPago( createDto.getCuotaPago() );
        egresosInterno.setMora( createDto.getMora() );
        egresosInterno.setMoraUltimosTresMeses( createDto.getMoraUltimosTresMeses() );

        return egresosInterno;
    }

    @Override
    public void updateEntity(EgresosInterno entity, EgresosInternoUpdateDto updateDto) {
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
    public EgresosInternoDto toDto(EgresosInterno entity) {
        if ( entity == null ) {
            return null;
        }

        EgresosInternoDto.EgresosInternoDtoBuilder egresosInternoDto = EgresosInternoDto.builder();

        egresosInternoDto.cedulaCliente( entity.getCedulaCliente() );
        egresosInternoDto.cuotaPago( entity.getCuotaPago() );
        egresosInternoDto.fechaActualizacion( entity.getFechaActualizacion() );
        egresosInternoDto.fechaRegistro( entity.getFechaRegistro() );
        egresosInternoDto.id( entity.getId() );
        egresosInternoDto.institucionBancaria( entity.getInstitucionBancaria() );
        egresosInternoDto.mesesPendientes( entity.getMesesPendientes() );
        egresosInternoDto.mora( entity.getMora() );
        egresosInternoDto.moraUltimosTresMeses( entity.getMoraUltimosTresMeses() );
        egresosInternoDto.nombres( entity.getNombres() );
        egresosInternoDto.producto( entity.getProducto() );
        egresosInternoDto.saldoPendiente( entity.getSaldoPendiente() );
        egresosInternoDto.version( entity.getVersion() );

        return egresosInternoDto.build();
    }

    @Override
    public List<EgresosInternoDto> toDtoList(List<EgresosInterno> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EgresosInternoDto> list = new ArrayList<EgresosInternoDto>( entities.size() );
        for ( EgresosInterno egresosInterno : entities ) {
            list.add( toDto( egresosInterno ) );
        }

        return list;
    }
}
