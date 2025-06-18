package com.fsse2410.parttimebackendproject.utill;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtill {
    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwt) {
        return new FirebaseUserData(jwt);
    }
}


