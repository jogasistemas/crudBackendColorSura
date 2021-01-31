package com.coloresreactivo.web;

import com.coloresreactivo.business.IUserService;
import com.coloresreactivo.model.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping()
    public Mono<Usuario> findUserByEmail(@PathParam("email") String email) {
        return userService.findUsuario(email);
    }

}
