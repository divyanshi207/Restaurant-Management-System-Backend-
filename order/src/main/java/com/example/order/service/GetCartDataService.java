package com.example.order.service;

import com.example.order.dto.CartDTO;
import com.example.order.entity.Order;
import com.example.order.exception.NoItemPresentInCart;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetCartDataService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    public CartDTO[] getData(String auth){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization",auth);
        HttpEntity<Void> entity=new HttpEntity<>(headers);
        ResponseEntity<CartDTO[]> response=restTemplate.exchange("http://localhost:7071/cart",
                HttpMethod.GET,
                entity,
                CartDTO[].class);
        CartDTO[] cartDTOS=response.getBody();
        return cartDTOS;
    }

    public Long totalAmount(String auth){
        Order order=new Order();
        CartDTO[] cart=getData(auth);
        long a=0;
        for(int i=0;i<cart.length;i++){
            a+=cart[i].getPrice();

        }
        if(a==0)
            throw new NoItemPresentInCart();
        else{
            order.setBill(a);
            orderRepository.save(order);
            return a;
        }
    }

    public String placeOrder(String auth){
        CartDTO[] cart=getData(auth);
        if(cart.length<=0){
            throw new NoItemPresentInCart();
        }
        else{
            System.out.println("total Amount to pay: "+ totalAmount(auth));
            return "Pay to Place Order";
        }
    }
}
