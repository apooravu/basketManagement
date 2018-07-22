package com.fruit.cart;

import com.fruit.exception.BasketException;
import com.fruit.itemManagement.ManageItem;

import java.util.HashMap;

public class Basket {

    private HashMap<ManageItem, Integer> items;

    public HashMap<ManageItem, Integer> getItems() {
        return items;
    }

    public Basket(){
        items = new HashMap<>();
    }

    public void addItem(ManageItem item){
        if(item == null){
            throw new BasketException("Shopping item cannot be null");
        }

        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item,1);
        }
    }

}
