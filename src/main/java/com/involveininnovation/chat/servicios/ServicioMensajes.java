package com.involveininnovation.chat.servicios;

import com.involveininnovation.chat.model.Mensaje;
import com.involveininnovation.chat.repositorios.RepositorioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMensajes {
    @Autowired
    RepositorioMensaje repositorioMensaje;
    public Mensaje save(Mensaje mensaje){
        return repositorioMensaje.save(mensaje);
    }
}
