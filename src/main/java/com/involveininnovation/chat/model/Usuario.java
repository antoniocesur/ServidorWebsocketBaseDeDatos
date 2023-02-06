package com.involveininnovation.chat.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true, nullable=false)
    private String nombre;
    @OneToMany
    @JoinColumn(name="emisor_id")
    private List<Mensaje> mensajes;

    public Usuario(){

    }
}
