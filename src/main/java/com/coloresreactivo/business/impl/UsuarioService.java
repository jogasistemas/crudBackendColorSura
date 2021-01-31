package com.coloresreactivo.business.impl;

import com.coloresreactivo.business.IUserService;
import com.coloresreactivo.model.entity.Usuario;
import com.coloresreactivo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService implements IUserService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> findUsuario(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
