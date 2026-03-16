package com.GuiDev.sistema_usuarios.usuario.dto;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha
) {
}
