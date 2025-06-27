package com.fsse2410.parttimebackendproject.controller;

import com.fsse2410.parttimebackendproject.domainObject.CartItemResponseData;
import com.fsse2410.parttimebackendproject.dto.CartItemResponseDto;
import com.fsse2410.parttimebackendproject.service.CartItemService;
import com.fsse2410.parttimebackendproject.utill.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart/items")
@CrossOrigin("http://localhost:5173")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("{pid}/{quantity}")
    public void addCartItem(@PathVariable int pid, @PathVariable int quantity,
            JwtAuthenticationToken jwt) {
        cartItemService.addCartItem(pid, quantity,
                JwtUtill.getFirebaseUserData(jwt));
    }

    @GetMapping()
    public List<CartItemResponseDto> getCartItems(JwtAuthenticationToken jwt) {
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();

        for (CartItemResponseData cartItemResponseData : cartItemService
                .getCartItemList(JwtUtill.getFirebaseUserData(jwt))) {
            cartItemResponseDtoList
                    .add(new CartItemResponseDto(cartItemResponseData));
        }

        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCartItem(@PathVariable int pid,
            @PathVariable int quantity, JwtAuthenticationToken jwt) {
        return new CartItemResponseDto(cartItemService.updateItem(pid, quantity,
                JwtUtill.getFirebaseUserData(jwt)));
    }

    @DeleteMapping("/{pid}")
    public void deleteCartItem(@PathVariable int pid,
            JwtAuthenticationToken jwt) {
        cartItemService.deleteItem(pid, JwtUtill.getFirebaseUserData(jwt));
    }
}
