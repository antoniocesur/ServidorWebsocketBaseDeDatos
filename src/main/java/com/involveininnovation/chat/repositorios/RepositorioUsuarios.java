package com.involveininnovation.chat.repositorios;

import com.involveininnovation.chat.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {
    public Usuario findById(long id);
    public Usuario findByNombre(String nombre);
}
