package org.condominio.backendapi.controller;

import org.condominio.backendapi.dto.LoginResquest;
import org.condominio.backendapi.entity.Usuario;
import org.condominio.backendapi.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody LoginResquest request) {
        return usuarioService.autenticar(
                request.getEmail(),
                request.getSenha()
        );
    }
}
