package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.SocialSkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialSkillRepository extends CrudRepository<SocialSkillEntity, Long> {
}
