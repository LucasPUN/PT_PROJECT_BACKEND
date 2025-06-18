package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import com.fsse2410.parttimebackendproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData){
        Optional<UserEntity> userEntityOptional = userRepository.findByFirebaseUid(firebaseUserData.getFirebaseUid());

        if(userEntityOptional.isPresent()){
            return userEntityOptional.get();
        }

        UserEntity userEntity = userRepository.save(new UserEntity(firebaseUserData));
        return userEntity;
    };
}

