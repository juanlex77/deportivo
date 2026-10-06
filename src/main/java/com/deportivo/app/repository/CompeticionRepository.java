package com.deportivo.app.repository;

import com.deportivo.app.model.Competicion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompeticionRepository extends MongoRepository<Competicion, String> {
}