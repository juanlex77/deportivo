package com.deportivo.app.repository;

import com.deportivo.app.model.Entrenador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntrenadorRepository extends MongoRepository<Entrenador, String> {
}