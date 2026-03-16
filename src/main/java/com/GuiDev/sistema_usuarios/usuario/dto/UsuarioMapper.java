package com.GuiDev.sistema_usuarios.usuario.dto;

import com.GuiDev.sistema_usuarios.usuario.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        return usuario;
    }
    public static UsuarioResponseDTO toDTO(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
