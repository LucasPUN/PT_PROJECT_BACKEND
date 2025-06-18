package com.fsse2410.parttimebackendproject.service;

import com.fsse2410.parttimebackendproject.domainObject.CartItemResponseData;
import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.entity.CartItemEntity;
import com.fsse2410.parttimebackendproject.entity.ProductEntity;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import com.fsse2410.parttimebackendproject.exception.ProductNotExist;
import com.fsse2410.parttimebackendproject.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private UserService userService;
    private ProductService productService;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public void addCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity);

        CartItemEntity cartItemEntity;
        if(existingCartItem.isPresent()){
            cartItemEntity = existingCartItem.get();
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
        } else {
            cartItemEntity = new CartItemEntity(userEntity, productEntity, quantity);
        }
        cartItemRepository.save(cartItemEntity);
    }

    @Override
    public List<CartItemResponseData> getCartItemList(FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemRepository.findByUser(userEntity)) {
            cartItemResponseDataList.add(
                    new CartItemResponseData(cartItemEntity)
            );
        }
        return cartItemResponseDataList;
    }

    @Override
    public CartItemResponseData updateItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);

        if (cartItemRepository.findByUserAndProduct(userEntity, productEntity).isPresent()) {
            CartItemEntity existingCartItem = cartItemRepository.findByUserAndProduct(userEntity,productEntity).get();
            existingCartItem.setQuantity(quantity);
            cartItemRepository.save(existingCartItem);
            return new CartItemResponseData(existingCartItem);
        }
        throw new ProductNotExist("Product Not Exist");
    }

    @Transactional
    @Override
    public void deleteItem(Integer pid, FirebaseUserData firebaseUserData){
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()){
            cartItemEntity = existingCartItem.get();
            cartItemRepository.delete(cartItemEntity);
        } else {
            throw new ProductNotExist("Product Not Exist");
        }
    }

    @Transactional
    @Override
    public void emptyCart(UserEntity userEntity){
        cartItemRepository.deleteAllByUser(userEntity);
    }

    @Override
    public List<CartItemEntity> getCartItemListByUserEntity(UserEntity userEntity){
        return cartItemRepository.findByUser(userEntity);
    }

}
