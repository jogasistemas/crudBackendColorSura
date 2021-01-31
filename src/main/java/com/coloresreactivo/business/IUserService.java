package com.coloresreactivo.business;

import com.coloresreactivo.model.entity.Usuario;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<Usuario> findUsuario(String email);
}
