package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SocioCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String dni;

    @NotNull
    @Past
    @MayorDeEdad
    private LocalDate fechaNacimiento;

    @NotBlank
    @Pattern(regexp = "\\+\\d+")
    private String telefono;
}
