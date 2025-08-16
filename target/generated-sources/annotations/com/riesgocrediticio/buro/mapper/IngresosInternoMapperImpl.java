package com.riesgocrediticio.buro.mapper;

import com.riesgocrediticio.buro.dto.IngresosInternoCreateDto;
import com.riesgocrediticio.buro.dto.IngresosInternoDto;
import com.riesgocrediticio.buro.dto.IngresosInternoUpdateDto;
import com.riesgocrediticio.buro.model.IngresosInterno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-16T16:50:17-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class IngresosInternoMapperImpl implements IngresosInternoMapper {

    @Override
    public IngresosInterno toEntity(IngresosInternoCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        IngresosInterno ingresosInterno = new IngresosInterno();

        ingresosInterno.setCedulaCliente( createDto.getCedulaCliente() );
        ingresosInterno.setNombres( createDto.getNombres() );
        ingresosInterno.setInstitucionBancaria( createDto.getInstitucionBancaria() );
        ingresosInterno.setProducto( createDto.getProducto() );
        ingresosInterno.setSaldoPromedioMes( createDto.getSaldoPromedioMes() );
        ingresosInterno.setNumeroCuenta( createDto.getNumeroCuenta() );

        return ingresosInterno;
    }

    @Override
    public void updateEntity(IngresosInterno entity, IngresosInternoUpdateDto updateDto) {
        if ( updateDto == null ) {
            return;
        }

        if ( updateDto.getInstitucionBancaria() != null ) {
            entity.setInstitucionBancaria( updateDto.getInstitucionBancaria() );
        }
        if ( updateDto.getProducto() != null ) {
            entity.setProducto( updateDto.getProducto() );
        }
        if ( updateDto.getSaldoPromedioMes() != null ) {
            entity.setSaldoPromedioMes( updateDto.getSaldoPromedioMes() );
        }
        if ( updateDto.getNumeroCuenta() != null ) {
            entity.setNumeroCuenta( updateDto.getNumeroCuenta() );
        }
    }

    @Override
    public IngresosInternoDto toDto(IngresosInterno entity) {
        if ( entity == null ) {
            return null;
        }

        IngresosInternoDto.IngresosInternoDtoBuilder ingresosInternoDto = IngresosInternoDto.builder();

        ingresosInternoDto.id( entity.getId() );
        ingresosInternoDto.cedulaCliente( entity.getCedulaCliente() );
        ingresosInternoDto.nombres( entity.getNombres() );
        ingresosInternoDto.institucionBancaria( entity.getInstitucionBancaria() );
        ingresosInternoDto.producto( entity.getProducto() );
        ingresosInternoDto.saldoPromedioMes( entity.getSaldoPromedioMes() );
        ingresosInternoDto.numeroCuenta( entity.getNumeroCuenta() );
        ingresosInternoDto.fechaActualizacion( entity.getFechaActualizacion() );
        ingresosInternoDto.fechaRegistro( entity.getFechaRegistro() );
        ingresosInternoDto.version( entity.getVersion() );

        return ingresosInternoDto.build();
    }

    @Override
    public List<IngresosInternoDto> toDtoList(List<IngresosInterno> entities) {
        if ( entities == null ) {
            return null;
        }

        List<IngresosInternoDto> list = new ArrayList<IngresosInternoDto>( entities.size() );
        for ( IngresosInterno ingresosInterno : entities ) {
            list.add( toDto( ingresosInterno ) );
        }

        return list;
    }
}
