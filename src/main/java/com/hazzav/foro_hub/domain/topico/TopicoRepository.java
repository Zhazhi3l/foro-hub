package com.hazzav.foro_hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByActivoTrue(Pageable paginacion);
}
