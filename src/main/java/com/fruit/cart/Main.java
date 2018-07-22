package com.fruit.cart;

import com.fruit.constant.Fruits;
import com.fruit.itemManagement.ManageItem;
import com.fruit.itemManagement.ManageItemImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basket basket = new Basket();
		ManageItem item = new ManageItemImpl(Fruits.LEMON,Fruits.LEMON_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.APPLE,Fruits.APPLE_PRICE);
		ManageItem item3 = new ManageItemImpl(Fruits.APPLE,Fruits.APPLE_PRICE);
		basket.addItem(item);
		basket.addItem(item2);
		basket.addItem(item3);
		CartProcessor man = new CartProcessor();
		System.out.println(man.getTotalPrice(basket));
	}

}
