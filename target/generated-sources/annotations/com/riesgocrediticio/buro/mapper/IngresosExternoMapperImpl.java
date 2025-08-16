package com.riesgocrediticio.buro.mapper;

import com.riesgocrediticio.buro.dto.IngresosExternoCreateDto;
import com.riesgocrediticio.buro.dto.IngresosExternoDto;
import com.riesgocrediticio.buro.dto.IngresosExternoUpdateDto;
import com.riesgocrediticio.buro.model.IngresosExterno;
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
public class IngresosExternoMapperImpl implements IngresosExternoMapper {

    @Override
    public IngresosExterno toEntity(IngresosExternoCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        IngresosExterno ingresosExterno = new IngresosExterno();

        ingresosExterno.setCedulaCliente( createDto.getCedulaCliente() );
        ingresosExterno.setNombres( createDto.getNombres() );
        ingresosExterno.setInstitucionBancaria( createDto.getInstitucionBancaria() );
        ingresosExterno.setProducto( createDto.getProducto() );
        ingresosExterno.setSaldoPromedioMes( createDto.getSaldoPromedioMes() );
        ingresosExterno.setNumeroCuenta( createDto.getNumeroCuenta() );

        return ingresosExterno;
    }

    @Override
    public void updateEntity(IngresosExterno entity, IngresosExternoUpdateDto updateDto) {
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
    public IngresosExternoDto toDto(IngresosExterno entity) {
        if ( entity == null ) {
            return null;
        }

        IngresosExternoDto.IngresosExternoDtoBuilder ingresosExternoDto = IngresosExternoDto.builder();

        ingresosExternoDto.id( entity.getId() );
        ingresosExternoDto.cedulaCliente( entity.getCedulaCliente() );
        ingresosExternoDto.nombres( entity.getNombres() );
        ingresosExternoDto.institucionBancaria( entity.getInstitucionBancaria() );
        ingresosExternoDto.producto( entity.getProducto() );
        ingresosExternoDto.saldoPromedioMes( entity.getSaldoPromedioMes() );
        ingresosExternoDto.numeroCuenta( entity.getNumeroCuenta() );
        ingresosExternoDto.fechaActualizacion( entity.getFechaActualizacion() );
        ingresosExternoDto.fechaRegistro( entity.getFechaRegistro() );
        ingresosExternoDto.version( entity.getVersion() );

        return ingresosExternoDto.build();
    }

    @Override
    public List<IngresosExternoDto> toDtoList(List<IngresosExterno> entities) {
        if ( entities == null ) {
            return null;
        }

        List<IngresosExternoDto> list = new ArrayList<IngresosExternoDto>( entities.size() );
        for ( IngresosExterno ingresosExterno : entities ) {
            list.add( toDto( ingresosExterno ) );
        }

        return list;
    }
}
