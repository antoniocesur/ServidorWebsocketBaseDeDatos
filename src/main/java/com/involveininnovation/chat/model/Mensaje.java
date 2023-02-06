package com.involveininnovation.chat.model;

import com.involveininnovation.chat.model.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name="emisor_id", nullable = false)
    private Usuario emisor;

    private LocalDate fecha;

    public Mensaje(){

    }
}
