package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.ResponsibilityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibilitiesRepository extends CrudRepository<ResponsibilityEntity, Long> {
}
