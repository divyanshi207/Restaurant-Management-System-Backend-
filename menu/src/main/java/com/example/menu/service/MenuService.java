package com.example.menu.service;

import com.example.menu.dto.MenuResponseDTO;
import com.example.menu.entity.FoodItem;
import com.example.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepo;

    public FoodItem postData(FoodItem data){
        return menuRepo.save(data);

    }
    public MenuResponseDTO getItem(int page, int size){
        PageRequest p=PageRequest.of(page,size);
        Page<FoodItem> menuPage=menuRepo.findAll(p);
        MenuResponseDTO menuResponseDTO=new MenuResponseDTO();
        menuResponseDTO.setMenus(menuPage.getContent());
        menuResponseDTO.setTotalItems(menuPage.getTotalElements());
        menuResponseDTO.setCurrentPage(menuPage.getNumber());
        menuResponseDTO.setTotalPage(menuPage.getTotalPages());
        return menuResponseDTO;
    }
//    public List<FoodItem> getItem(){
//        List<FoodItem> list=menuRepo.findAll();
//        return list;
//    }
    public Optional<FoodItem> getById(Long id){
        return menuRepo.findById(id);
    }
    public List<FoodItem> delete(Long id){
        Optional<FoodItem> fi=menuRepo.findById(id);
        if(fi.isPresent()){
            menuRepo.deleteById(id);
        }

        return menuRepo.findAll();
    }

    public FoodItem update(Long id, int price){
        FoodItem foodItem =menuRepo.findById(id).orElseThrow(()-> new RuntimeException("Not found element"));
        foodItem.setPrice(price);
        return menuRepo.save(foodItem);
    }
}
