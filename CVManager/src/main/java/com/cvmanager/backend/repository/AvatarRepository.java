package com.cvmanager.backend.repository;

import com.cvmanager.backend.models.entity.AvatarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends CrudRepository<AvatarEntity, Long> {
}
