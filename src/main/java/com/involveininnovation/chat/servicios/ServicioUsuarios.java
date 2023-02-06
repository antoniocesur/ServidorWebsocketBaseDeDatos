package com.involveininnovation.chat.servicios;

import com.involveininnovation.chat.model.Usuario;
import com.involveininnovation.chat.repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarios {
    @Autowired
    RepositorioUsuarios repositorioUsuarios;
    public Usuario findById(long id){
        return repositorioUsuarios.findById(id);
    }
    public Usuario findByNombre(String nombre){
        return repositorioUsuarios.findByNombre(nombre);
    }
    public Usuario save(Usuario usuario){
        return repositorioUsuarios.save(usuario);
    }
}
