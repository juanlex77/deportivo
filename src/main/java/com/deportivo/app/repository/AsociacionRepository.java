package com.deportivo.app.repository;

import com.deportivo.app.model.Asociacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsociacionRepository extends MongoRepository<Asociacion, String> {
}