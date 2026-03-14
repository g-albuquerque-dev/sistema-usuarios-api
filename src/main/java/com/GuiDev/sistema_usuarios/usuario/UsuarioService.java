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
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado!"));
    }

    public Usuario salvar(Usuario usuario) {
        return repository.saveAndFlush(usuario);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado){
        Usuario usuarioExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return repository.save(usuarioExistente);
    }

    public void excluirPorEmail(String email){
        Usuario usuarioParaDeletar = buscarPorEmail(email);
        repository.delete(usuarioParaDeletar);
    }
}
