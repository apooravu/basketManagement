package com.fruit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fruit.cart.Basket;
import com.fruit.constant.Fruits;
import com.fruit.exception.BasketException;
import com.fruit.itemManagement.ManageItem;
import com.fruit.itemManagement.ManageItemImpl;

public class BasketTest {

	private Basket basket = new Basket();

	@Test(expected = BasketException.class)
	public void testAddNullItem() {
		basket.addItem(null);
	}

	@Test
	public void testAddOneItem() {
		ManageItem item = new ManageItemImpl(Fruits.APPLE, Fruits.APPLE_PRICE);
		basket.addItem(item);

		assertEquals(1, basket.getItems().size());
	}

	@Test
	public void testAdd2DifferentItems() {
		ManageItem item1 = new ManageItemImpl(Fruits.APPLE, Fruits.APPLE_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals(2, basket.getItems().size());
	}

	@Test
	public void testAdd2ItemsOfSameType() {
		ManageItem item1 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals(1, basket.getItems().size());
		assertEquals(new Integer(2), basket.getItems().get(item1));
	}
}