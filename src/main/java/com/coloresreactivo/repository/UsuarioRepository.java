package com.coloresreactivo.repository;

import com.coloresreactivo.model.entity.Usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

@ComponentScan
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {

    Mono<Usuario> findByEmail(String email);

}
