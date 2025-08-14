package com.hazzav.foro_hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        @NotNull
        Status estado
) {
}
