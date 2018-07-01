package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.ProjectIdEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends CrudRepository<ProjectIdEntity, Long> {
}
