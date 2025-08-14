package com.hazzav.foro_hub.controller;

import com.hazzav.foro_hub.domain.topico.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crearTopico(@RequestBody @Valid DatosResgistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datos);
        topicoRepository.save(topico);

        var uri = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();

        //return ResponseEntity.ok().build();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listar(@PageableDefault(size = 10, sort={"fecha"}) Pageable paginacion){
        var pagina = topicoRepository.findAllByActivoTrue(paginacion)
                .map(DatosDetalleTopico::new);
        return ResponseEntity.ok(pagina);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        Optional<Topico> topico = topicoRepository.findById(datos.id());

        if(!topico.isPresent()) {
            topico.get().actualizarInformacion(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topico.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        topico.eliminar();

        return ResponseEntity.noContent().build();
    }

}
