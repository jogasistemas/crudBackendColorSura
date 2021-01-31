package com.coloresreactivo.repository;

import com.coloresreactivo.model.entity.ColoresEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ColorRepository extends ReactiveCrudRepository<ColoresEntity, Integer> {
}
