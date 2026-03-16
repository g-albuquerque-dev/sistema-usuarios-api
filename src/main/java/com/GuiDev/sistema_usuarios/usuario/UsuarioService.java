package com.GuiDev.sistema_usuarios.usuario;

import com.GuiDev.sistema_usuarios.usuario.dto.UsuarioMapper;
import com.GuiDev.sistema_usuarios.usuario.dto.UsuarioRequestDTO;
import com.GuiDev.sistema_usuarios.usuario.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    private Usuario BuscarEntidadePorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    private void converterDtoParaEntidade(UsuarioUpdateDTO dto, Usuario entidade){
        if(dto.nome() != null){
            entidade.setNome(dto.nome());
        }
        if (dto.senhaNova() != null){
            entidade.setSenha(dto.senhaNova());
        }
    }

    @Transactional
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto){
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario usuarioSalvo = repository.save(usuario);
        return UsuarioMapper.toDTO(usuarioSalvo);
    }

    public List<UsuarioResponseDTO> listarTodos(){
        return repository.findAll().stream()
                .map(UsuarioMapper::toDTO) //Traduz cada usuário da lista para DTO
                .toList();
    }
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = BuscarEntidadePorId(id);
        return UsuarioMapper.toDTO(usuario);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.saveAndFlush(usuario);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto){
        Usuario usuario = BuscarEntidadePorId(id);
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        Usuario usuarioAtualizado = repository.save(usuario);
        return UsuarioMapper.toDTO(usuarioAtualizado);
    }

    @Transactional
    public void excluirPorEmail(Long id){
        Usuario usuario  = BuscarEntidadePorId(id);
        repository.delete(usuario);
    }
}
