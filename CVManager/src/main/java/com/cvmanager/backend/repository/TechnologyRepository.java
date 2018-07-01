package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.TechnologyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends CrudRepository<TechnologyEntity, Long> {
}
