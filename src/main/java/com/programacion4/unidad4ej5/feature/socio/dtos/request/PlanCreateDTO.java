package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class PlanCreateDTO {

    @NotBlank(message = "El objetivo no puede estar vacío")
    @Size(min = 10, max = 200, message = "El objetivo debe tener entre 10 y 200 caracteres")
    private String objetivo;

    @NotNull(message = "La frecuencia semanal no puede ser nula")
    @Min(value = 1, message = "La frecuencia debe ser al menos 1 día")
    @Max(value = 7, message = "La frecuencia no puede superar 7 días")
    private Integer frecuenciaSemanal;

    @NotNull(message = "El peso inicial no puede ser nulo")
    @DecimalMin(value = "30.0", message = "El peso mínimo es 30.0 kg")
    @DecimalMax(value = "250.0", message = "El peso máximo es 250.0 kg")
    private Double pesoInicial;

    @NotNull(message = "La altura no puede ser nula")
    @DecimalMin(value = "1.0", message = "La altura mínima es 1.0 m")
    @DecimalMax(value = "2.5", message = "La altura máxima es 2.5 m")
    private Double altura;

    @NotEmpty(message = "La lista de ejercicios no puede estar vacía")
    @Size(min = 3, message = "Debe haber al menos 3 ejercicios")
    private List<@NotBlank(message = "El ejercicio no puede estar vacío") String> ejercicios;
}