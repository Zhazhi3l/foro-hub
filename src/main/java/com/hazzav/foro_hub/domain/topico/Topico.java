package com.hazzav.foro_hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    public void actualizarInformacion(@Valid DatosActualizacionTopico datos) {
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.autor() != null){
            this.autor = datos.autor();
        }
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
        if(datos.estado() != null){
            this.status = datos.estado();
        }
        this.fecha = LocalDateTime.now();
    }

    public void eliminar() {
        this.activo = false;
        this.status = Status.INACTIVO;
    }

}
