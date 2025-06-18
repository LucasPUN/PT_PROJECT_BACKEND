package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.CartItemResponseData;
import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.entity.CartItemEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;

import java.util.List;

public interface CartItemService {
    void addCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);

    List<CartItemResponseData> getCartItemList(FirebaseUserData firebaseUserData);

    CartItemResponseData updateItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);

    void deleteItem(Integer pid, FirebaseUserData firebaseUserData);

    void emptyCart(UserEntity userEntity);

    List<CartItemEntity> getCartItemListByUserEntity(UserEntity userEntity);
}
