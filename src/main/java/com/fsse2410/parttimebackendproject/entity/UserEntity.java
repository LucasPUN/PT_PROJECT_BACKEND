package com.fsse2410.parttimebackendproject.entity;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "firebase_uid", nullable = false, unique = true)
    private String firebaseUid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public UserEntity(FirebaseUserData firebaseUserData) {
        this.firebaseUid = firebaseUserData.getFirebaseUid();
        this.email = firebaseUserData.getEmail();
    }

    public UserEntity() {

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
