package com.example.orders.controller;


import com.example.orders.dto.CartResponseDTO;
import com.example.orders.entity.Cart;
import com.example.orders.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService os;

    @GetMapping
    public CartResponseDTO get(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5")int size){
        return os.getCart(page,size);
    }

    @PostMapping("/add/{id}")
    public Cart addtocart(@PathVariable Long id, HttpServletRequest request){
        String authH=request.getHeader("Authorization");
        return os.addtocart(id, authH);
    }

    @DeleteMapping("/removeItem")
    public List<Cart> deleteItem(@RequestParam("id") Long id, HttpServletRequest request) {
        String authH=request.getHeader("Authorization");
        return os.editcart(id,authH);
    }
}
