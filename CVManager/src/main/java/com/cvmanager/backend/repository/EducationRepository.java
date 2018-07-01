package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.EducationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<EducationEntity, Long> {
}
