package com.GuiDev.sistema_usuarios.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarTodos(){
        return repository.findAll(); // O JPA faz o SELECT * FROM tb_usuarios sozinho!
    }

    public Usuario salvar(Usuario usuario) {

        return repository.save(usuario);
    }
}
