package br.com.doit.doit.repositories;

import br.com.doit.doit.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findAllById(Long id);
}
