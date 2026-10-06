package com.deportivo.app.repository;

import com.deportivo.app.model.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadorRepository extends MongoRepository<Jugador, String> {
}