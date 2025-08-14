package com.hazzav.foro_hub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    private String curso;
    private Boolean activo;

    public Topico(DatosResgistroTopico datos) {
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = Status.ACTIVO;
        this.autor = datos.autor();
        this.curso = datos.curso();
    }

}
