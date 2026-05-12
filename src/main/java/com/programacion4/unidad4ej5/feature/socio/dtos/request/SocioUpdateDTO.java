package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class SocioUpdateDTO {

    @Null(
            groups = ValidationGroups.OnCreate.class,
            message = "El ID debe ser nulo al crear"
    )
    @NotNull(
            groups = ValidationGroups.OnUpdate.class,
            message = "El ID es obligatorio al actualizar"
    )
    private Long id;

    @URL(message = "La URL de la foto debe ser válida")
    private String urlFoto;

    @Pattern(
            regexp = "\\S{3,15}",
            message = "El alias debe tener entre 3 y 15 caracteres sin espacios"
    )
    private String alias;
}