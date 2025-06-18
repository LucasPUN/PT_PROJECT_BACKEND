package com.fsse2410.parttimebackendproject.repository;

import com.fsse2410.parttimebackendproject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByFirebaseUid(String firebaseUid);
}
