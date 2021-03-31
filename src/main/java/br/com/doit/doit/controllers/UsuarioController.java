package br.com.doit.doit.controllers;

import br.com.doit.doit.models.Usuario;
import br.com.doit.doit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }

    @PostMapping("/usuarios")
    public Usuario inserirUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.inserirOuAtualizar(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.inserirOuAtualizar(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public void excluirUsuario(@PathVariable("id") Long id){
        this.usuarioService.excluirUsuario(id);
    }

}
