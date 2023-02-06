package com.involveininnovation.chat.repositorios;

import com.involveininnovation.chat.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMensaje extends JpaRepository<Mensaje, Long> {

}
