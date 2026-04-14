package com.example.menu.controller;

import com.example.menu.dto.MenuResponseDTO;
import com.example.menu.entity.FoodItem;
import com.example.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/item")
    public FoodItem postdata(@RequestBody FoodItem data) {
        System.out.println(data);
       return menuService.postData(data);
    }
    @GetMapping("/getAllItem")
    public MenuResponseDTO getAll(@RequestParam(defaultValue ="0") int page, @RequestParam(defaultValue = "5") int size){
        return menuService.getItem(page,size);
    }

    @GetMapping("/get/{id}")
    public Optional<FoodItem> getById(@PathVariable Long id){
        return menuService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<FoodItem> delete(@PathVariable Long id){
        return menuService.delete(id);
    }

    @PutMapping("/update/{id}")
    public FoodItem updatePrice(@PathVariable Long id){
        return menuService.update(id,120);
    }

}
