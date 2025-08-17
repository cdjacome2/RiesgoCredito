package com.riesgocrediticio.buro.controller;

import com.riesgocrediticio.buro.dto.response.ConsultaBuroCreditoResponse;
import com.riesgocrediticio.buro.service.BuroCreditoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/v1", produces = "application/json")
@Tag(name = "Buró Crediticio", description = "API para consultar información de buró crediticio interno y externo")
@Validated
@CrossOrigin(origins = "*")
public class BuroCreditoController {

    private final BuroCreditoService buroCreditoService;

    public BuroCreditoController(BuroCreditoService buroCreditoService) {
        this.buroCreditoService = buroCreditoService;
    }

    @Operation(
        summary = "Consulta información de buró crediticio por cédula",
        description = "Retorna todos los ingresos y egresos internos/externos del cliente, con mock si no existe información registrada."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Consulta exitosa",
            content = @Content(schema = @Schema(implementation = ConsultaBuroCreditoResponse.class))),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado en el core",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/consulta-por-cedula/{cedula}")
    public ResponseEntity<ConsultaBuroCreditoResponse> consultarPorCedula(
        @Parameter(description = "Cédula del cliente a consultar", required = true)
        @PathVariable @NotBlank String cedula) {

        log.debug("Solicitud recibida → Consulta de buró por cédula={}", cedula);
        ConsultaBuroCreditoResponse response = buroCreditoService.consultarPorCedula(cedula);
        log.info("Consulta de buró crediticio exitosa para cédula={}", cedula);
        return ResponseEntity.ok(response);
    }
    
    @Operation(
        summary = "Sincroniza todos los clientes tipo PERSONA desde el core al buró interno",
        description = "Carga masiva de clientes del core. Devuelve un mensaje con el total de registros creados."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sincronización exitosa",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    
    @PostMapping("/sincronizar-core")
    public ResponseEntity<String> sincronizarDesdeCore() {

        // Generar una clave idempotente única basada en un UUID
        String idempotencyKey = UUID.randomUUID().toString();
        log.info("Generando nueva idempotencyKey: {}", idempotencyKey);

        log.info("Solicitud recibida → Sincronización masiva desde el core");
        String mensaje = buroCreditoService.sincronizarClientesDesdeCore(idempotencyKey);
        log.info("Sincronización finalizada: {}", mensaje);
        return ResponseEntity.ok(mensaje);
    }

    @Operation(
        summary = "Cuenta el número de clientes PERSONA en el core",
        description = "Retorna el total de registros de clientes tipo PERSONA existentes en el microservicio core."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Conteo exitoso",
            content = @Content(schema = @Schema(implementation = Integer.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/count-core-personas")
    public ResponseEntity<Integer> contarPersonasCore() {
        log.info("Solicitud recibida → Conteo de clientes tipo PERSONA en el core");
        int total = buroCreditoService.contarPersonasEnCore();
        log.info("Total de personas tipo PERSONA en core: {}", total);
        return ResponseEntity.ok(total);
    }

    @Operation(
    summary = "Sincroniza clientes del buró interno al externo",
    description = "Copia todos los clientes existentes en el buró interno al buró externo si aún no existen. Ideal para la carga mensual."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sincronización exitosa",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @PostMapping("/sincronizar-interno-externo")
    public ResponseEntity<String> sincronizarClientesDesdeInternoAExterno() {

        String idempotencyKey = UUID.randomUUID().toString();
        log.info("Generando nueva idempotencyKey: {}", idempotencyKey);
        
        log.info("Solicitud recibida → Sincronización de clientes internos a externos");
        String mensaje = buroCreditoService.sincronizarClientesDesdeInternoAExterno(idempotencyKey);
        log.info("Sincronización interno-externo finalizada: {}", mensaje);
        return ResponseEntity.ok(mensaje);
    }

    @Operation(
        summary = "Genera clientes externos mock",
        description = "Genera un número determinado de clientes externos ficticios (mock) que no existen en el buró interno. Útil para pruebas y simulaciones."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Generación exitosa",
            content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "400", description = "Cantidad no válida"),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @PostMapping("/generar-clientes-externos/{cantidad}")
    public ResponseEntity<String> generarClientesExternos(
        @Parameter(description = "Cantidad de clientes externos mock a generar", example = "20", required = true)
        @PathVariable int cantidad) {
        log.info("Solicitud recibida → Generar {} clientes externos mock", cantidad);
        int creados = buroCreditoService.generarClientesExternosMock(cantidad);
        String mensaje = "Se generaron " + creados + " clientes externos.";
        log.info("Generación de clientes externos mock finalizada: {}", mensaje);
        return ResponseEntity.ok(mensaje);
    }

    @Operation(
        summary = "Cuenta el número de clientes en el buro interno",
        description = "Retorna el total de registros de clientes existentes en el buro interno."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Conteo exitoso",
            content = @Content(schema = @Schema(implementation = Integer.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/clientes-internos")
    public int contarClientesEnBuroInterno() {
        try {
            // Llamar al servicio para contar los clientes en el buro interno
            int totalClientes = buroCreditoService.contarClientesEnBuroInterno();
            log.info("Total de clientes en buro interno: {}", totalClientes);
            return totalClientes;
        } catch (Exception ex) {
            log.error("Error al contar los clientes en el buro interno: {}", ex.getMessage(), ex);
            throw new RuntimeException("Error al contar los clientes en el buro interno", ex);
        }
    }

    @Operation(
        summary = "Cuenta el número de clientes en el buro externo",
        description = "Cuenta clientes únicos (por cédula) con registros externos."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Conteo exitoso",
            content = @Content(schema = @Schema(implementation = Integer.class))),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/clientes-externos/count")
    public ResponseEntity<Integer> contarClientesEnBuroExterno() {
        log.info("Solicitud recibida → Conteo de clientes en buró externo");
        int total = buroCreditoService.contarClientesEnBuroExterno();
        return ResponseEntity.ok(total);
    }

    @Operation(
    summary = "Lista clientes del buró externo",
    description = "Agrupa por cédula y devuelve ingresos/egresos, calificación y capacidad de pago. " +
                  "Si no se envían parámetros, retorna TODO el buró externo."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listado exitoso"),
        @ApiResponse(responseCode = "500", description = "Error interno")
    })
    @GetMapping("/clientes-externos")
    public ResponseEntity<List<ConsultaBuroCreditoResponse>> listarClientesExterno(
        @Parameter(
            description = "Institución a filtrar. " +
                        "Ej: 'BANCO BANQUITO' o 'BANCO FICTICIO 1'. " +
                        "Si se omite, no se aplica filtro por institución.",
            example = "BANCO BANQUITO",
            required = false
        )
        @RequestParam(name = "institucion", required = false) String institucion,
        @Parameter(
            description = "true = traer SOLO la institución indicada; false = EXCLUIR la institución indicada. " +
                        "Por defecto false.",
            example = "false",
            required = false
        )
        @RequestParam(name = "incluirSolo", defaultValue = "false") boolean incluirSolo
    ) {
        log.info("Solicitud recibida → Listar clientes externos (institucion='{}', incluirSolo={})", institucion, incluirSolo);
        List<ConsultaBuroCreditoResponse> lista = buroCreditoService.listarClientesExterno(institucion, incluirSolo);
        return ResponseEntity.ok(lista);
    }

}
