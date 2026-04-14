package com.example.orders.service;
import com.example.orders.dto.CartResponseDTO;
import com.example.orders.exception.ItemInCartWithIdNotFound;
import com.example.orders.exception.ItemwithIdNotFound;
import com.example.orders.dto.FoodItem;
import com.example.orders.entity.Cart;
import com.example.orders.repository.CartRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CartService {

    @Autowired
    RestTemplate restTemplate;


//   public List<Cart> getCart(){
//       return cartrepo.findAll();
//   }
//   add to cart
    public CartResponseDTO getCart(int page,int size){
        PageRequest p=PageRequest.of(page, size);
        Page<Cart> carts= cartrepo.findAll(p);
        CartResponseDTO cartResponseDTO=new CartResponseDTO();
        cartResponseDTO.setCartItems(carts.getContent());
        cartResponseDTO.setCurrentPage(carts.getNumber());
        cartResponseDTO.setTotalItems(carts.getTotalElements());
        cartResponseDTO.setTotalPage(carts.getTotalPages());
        return cartResponseDTO;
    }
    @Autowired
    CartRepo cartrepo;
    public Cart addtocart(Long id, String request) {

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization", request);
        HttpEntity<Void> entity=new HttpEntity<>(headers);
        ResponseEntity<FoodItem> response =restTemplate.exchange
                ("http://localhost:7070/menu/get/" +id,
                        HttpMethod.GET
                        ,entity,
                        FoodItem.class);
        FoodItem food=response.getBody();

        if (food == null)
            throw new ItemwithIdNotFound(id);
        else {
            Cart exist=cartrepo.findByItemId(id);
            if(exist==null) {
                Cart cart = new Cart();
                cart.setName(food.name);
                cart.setPrice(food.price);
                cart.setItemId(food.id);
                return cartrepo.save(cart);
            }
            else{
                int cu=exist.getPrice();
                exist.setPrice(cu+ food.price);
                return cartrepo.save(exist);
            }
        }
    }

//    edit cart minus
    public List<Cart> editcart(Long id, String request)throws ItemInCartWithIdNotFound{
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization", request);
        HttpEntity<Void> entity=new HttpEntity<>(headers);
        ResponseEntity<FoodItem> response =restTemplate.exchange
                ("http://localhost:7070/menu/get/" +id, HttpMethod.GET
                        ,entity, FoodItem.class);
        FoodItem food=response.getBody();
        Cart c=cartrepo.findByItemId(id);
        if(c==null){
            throw new ItemInCartWithIdNotFound(id);
        }
        else{
            c.setPrice(c.getPrice()-food.price);
            cartrepo.save(c);
            if(c.getPrice()==0)
                cartrepo.delete(c);
            return cartrepo.findAll();
        }
    }

}
