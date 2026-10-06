package com.deportivo.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "clubes")
public class Club {

    @Id
    private String id;
    private String nombre;

    // Relación Uno a Uno: Club -> Entrenador
    @DocumentReference
    private Entrenador entrenador;

    // Relación Uno a Muchos: Club -> Jugadores
    @DocumentReference
    private List<Jugador> jugadores = new ArrayList<>();

    // Relación Muchos a Uno: Club -> Asociación
    @DocumentReference
    private Asociacion asociacion;

    // Relación Muchos a Muchos: Club <-> Competiciones
    @DocumentReference
    private List<Competicion> competiciones = new ArrayList<>();

    public Club() {}

    public Club(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }
    public Asociacion getAsociacion() { return asociacion; }
    public void setAsociacion(Asociacion asociacion) { this.asociacion = asociacion; }
    public List<Competicion> getCompeticiones() { return competiciones; }
    public void setCompeticiones(List<Competicion> competiciones) { this.competiciones = competiciones; }
}