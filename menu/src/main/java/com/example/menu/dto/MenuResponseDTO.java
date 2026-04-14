package com.example.menu.dto;

import com.example.menu.entity.FoodItem;

import java.util.List;

public class MenuResponseDTO {
    private List<FoodItem> menus;

    public List<FoodItem> getMenus() {
        return menus;
    }

    public void setMenus(List<FoodItem> menus) {
        this.menus = menus;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    private int currentPage;
    private int totalPage;
    private Long totalItems;

}
