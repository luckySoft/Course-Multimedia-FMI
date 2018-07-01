package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.LanguageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageEntity, Long> {
}
