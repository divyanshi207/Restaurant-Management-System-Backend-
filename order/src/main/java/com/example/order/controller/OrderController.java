package com.example.order.controller;


import com.example.order.dto.CartDTO;
import com.example.order.service.GetCartDataService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    GetCartDataService getCartDataService;

    @GetMapping
    public CartDTO[] getCartData(HttpServletRequest request){
        String authH=request.getHeader("Authorization");
        return getCartDataService.getData(authH);
    }

    @GetMapping("/bill")
    public Long getBill(HttpServletRequest request){
        String authH=request.getHeader("Authorization");
        return getCartDataService.totalAmount(authH);
    }

    @GetMapping("/place-order")
    public String placeOrder(HttpServletRequest request){
        String authH=request.getHeader("Authorization");
        return getCartDataService.placeOrder(authH);
    }

}
