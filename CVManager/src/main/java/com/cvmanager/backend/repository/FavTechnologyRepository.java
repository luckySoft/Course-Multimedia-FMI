package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.FavTechnologyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavTechnologyRepository extends CrudRepository<FavTechnologyEntity, Long> {
}
