package org.condominio.backendapi.service;

import org.condominio.backendapi.entity.StatusUsuario;
import org.condominio.backendapi.entity.Usuario;
import org.condominio.backendapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(Usuario usuario) {
        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Usuário já existe");
        }
        usuario.setSenha(

                passwordEncoder.encode(usuario.getSenha())

        );
        usuario.setCriadoEm(LocalDateTime.now());
        usuario.setStatus(StatusUsuario.ATIVO);

        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario buscarPorEmail(String email) {

        return usuarioRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("Usuário não encontrado")
                );

    }
    public Usuario autenticar(String email, String senha) {

        Usuario usuario = buscarPorEmail(email);

        boolean senhaOk = passwordEncoder.matches(
                senha,
                usuario.getSenha()
        );

        if (!senhaOk) {
            throw new RuntimeException("Senha inválida");
        }

        return usuario;
    }

    public void deletar(Long id) {

        Usuario usuario = findById(id);

        usuarioRepository.delete(usuario);
    }
}
