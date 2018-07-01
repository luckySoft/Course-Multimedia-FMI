package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.SkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<SkillEntity, Long> {
}
