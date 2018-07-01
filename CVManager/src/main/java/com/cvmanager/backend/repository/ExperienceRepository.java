package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.ExperienceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends CrudRepository<ExperienceEntity, Long> {
}
