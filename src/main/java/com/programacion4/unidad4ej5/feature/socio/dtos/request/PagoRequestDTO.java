package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PagoRequestDTO {

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "1000.00", message = "El monto mínimo es 1000.00")
    @Digits(integer = 10, fraction = 2, message = "El monto soporta hasta 2 decimales")
    private BigDecimal monto;

    @NotBlank(message = "El código de transacción no puede estar vacío")
    @Pattern(
            regexp = "PAY-[A-Z0-9]{4}-[A-Z0-9]{4}",
            message = "El código debe seguir el patrón PAY-XXXX-XXXX"
    )
    private String codigoTransaccion;

    @NotNull(message = "La fecha de vencimiento no puede ser nula")
    @Future(message = "La fecha de vencimiento debe ser futura")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El tipo de pago no puede estar vacío")
    @Pattern(
            regexp = "EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA",
            message = "El tipo de pago debe ser: EFECTIVO, DEBITO, CREDITO o TRANSFERENCIA"
    )
    private String tipoPago;
}