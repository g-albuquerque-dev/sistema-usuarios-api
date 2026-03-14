package com.GuiDev.sistema_usuarios.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listarTodos(){
        return service.listarTodos();
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return service.salvar(usuario);
    }
}
