package com.hazzav.foro_hub.domain.topico;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        String fecha,
        Status estado,
        String autor,
        String curso
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha().toString(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
