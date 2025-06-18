package com.fsse2410.parttimebackendproject.controller;

import com.fsse2410.parttimebackendproject.domainObject.FirebaseUserData;
import com.fsse2410.parttimebackendproject.domainObject.ProductResponseData;
import com.fsse2410.parttimebackendproject.dto.ProductByIdResponseDto;
import com.fsse2410.parttimebackendproject.dto.ProductGetAllRepsonseDto;
import com.fsse2410.parttimebackendproject.entity.UserEntity;
import com.fsse2410.parttimebackendproject.service.ProductService;
import com.fsse2410.parttimebackendproject.utill.JwtUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<ProductGetAllRepsonseDto> getAllProducts() {
        List<ProductResponseData> productResponseDataList =
                productService.getAllProduct();
        List<ProductGetAllRepsonseDto> productGetAllRepsonseDtoList =
                new ArrayList<>();

        for (ProductResponseData productResponseData : productResponseDataList) {
            productGetAllRepsonseDtoList
                    .add(new ProductGetAllRepsonseDto(productResponseData));
        }

        return productGetAllRepsonseDtoList;
    }

    @GetMapping("/{id}")
    public ProductByIdResponseDto findById(@PathVariable("id") Integer id) {
        return new ProductByIdResponseDto(productService.getProductById(id));
    }
    //
    // @GetMapping("/user")
    // public UserEntity getCurrentUser(JwtAuthenticationToken jwt) {
    // FirebaseUserData firebaseUserData = JwtUtill.getFirebaseUserData(jwt);
    // return new UserEntity(firebaseUserData);
    // }
}
