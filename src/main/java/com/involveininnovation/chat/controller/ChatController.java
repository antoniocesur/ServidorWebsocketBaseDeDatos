package com.involveininnovation.chat.controller;

import com.involveininnovation.chat.model.Mensaje;
import com.involveininnovation.chat.model.Message;
import com.involveininnovation.chat.model.Status;
import com.involveininnovation.chat.model.Usuario;
import com.involveininnovation.chat.servicios.ServicioMensajes;
import com.involveininnovation.chat.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class ChatController {
    @Autowired
    private ServicioMensajes servicioMensajes;
    @Autowired
    private ServicioUsuarios servicioUsuarios;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        //Solo lo guardo si es mensaje real
        if(message.getStatus().equals(Status.MESSAGE)) {
            //Busco un usuario con el nombre del emisor
            Usuario usuario = servicioUsuarios.findByNombre(message.getSenderName());
            //Si no existe, lo creo
            if (usuario == null) {
                usuario = new Usuario();
                usuario.setNombre(message.getSenderName());
                servicioUsuarios.save(usuario);
            }
            Mensaje mensaje = new Mensaje();
            mensaje.setEmisor(usuario);
            mensaje.setContenido(message.getMessage());
            mensaje.setFecha(LocalDate.now());
            servicioMensajes.save(mensaje);
        }
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }
}
