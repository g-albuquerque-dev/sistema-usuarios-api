package com.GuiDev.sistema_usuarios.usuario;


import com.GuiDev.sistema_usuarios.usuario.dto.UsuarioRequestDTO;
import com.GuiDev.sistema_usuarios.usuario.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO dto){
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

}
