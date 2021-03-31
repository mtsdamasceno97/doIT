package br.com.doit.doit.services;

import br.com.doit.doit.models.Usuario;
import br.com.doit.doit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> getUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario inserirOuAtualizar(Usuario usuario){
        String encodedPassword = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encodedPassword);
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    public void excluirUsuario(Long id){
        this.usuarioRepository.deleteById(id);

    }

    public Usuario alterarUsuario(Long id, Usuario usuarioNovo){
        Usuario usuario = this.usuarioRepository.findAllById(id);
        usuario = usuarioNovo;
        return usuario;
    }

}


