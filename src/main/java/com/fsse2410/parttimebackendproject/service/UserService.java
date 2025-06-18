package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.entity.UserEntity;

public interface UserService {
    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);
}
