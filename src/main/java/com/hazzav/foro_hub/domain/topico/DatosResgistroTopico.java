package com.hazzav.foro_hub.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosResgistroTopico(
    @NotNull
    String titulo,
    @NotNull
    String mensaje,
    @NotNull
    String autor,
    @NotNull
    String curso
) {
}
