package com.fruit.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.fruit.cart.CartProcessor;
import com.fruit.cart.Basket;
import com.fruit.constant.Fruits;
import com.fruit.exception.BasketException;
import com.fruit.itemManagement.ManageItem;
import com.fruit.itemManagement.ManageItemImpl;

public class CartProcessorTest {

	private CartProcessor cartProcessor ;
	
	@Before
	public void TearUp(){
		cartProcessor = new CartProcessor();
	}

	@Test
	public void testWithNoItemsInBasket() throws Exception {
		Basket basket = new Basket();
		BigDecimal actual = cartProcessor.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(0);
		assertTrue(actual.compareTo(expected) == 0);
	}

	@Test
	public void tesWithOnetItemsInBasket() throws Exception {
		Basket basket = new Basket();
		ManageItem item = new ManageItemImpl(Fruits.APPLE, Fruits.APPLE_PRICE);
		basket.addItem(item);

		BigDecimal actual = cartProcessor.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(30);
		assertTrue(actual.compareTo(expected) == 0);
	}

	@Test
	public void testWithTwoSameItemsInBaskety() throws Exception {
		Basket basket = new Basket();
		ManageItem item1 = new ManageItemImpl(Fruits.ORANGE, Fruits.ORANGE_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.ORANGE, Fruits.ORANGE_PRICE);
		basket.addItem(item1);
		basket.addItem(item2);
		BigDecimal actual = cartProcessor.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(40);
		assertTrue(actual.compareTo(expected) == 0);
	}

	@Test
	public void testWithThreeDifferentItemsInBasket() throws Exception {
		Basket basket = new Basket();
		ManageItem item1 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.APPLE, Fruits.APPLE_PRICE);
		ManageItem item3 = new ManageItemImpl(Fruits.LEMON, Fruits.LEMON_PRICE);
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);

		BigDecimal actual = cartProcessor.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(55);
		assertTrue(actual.compareTo(expected) == 0);

	}

	@Test
	public void testWithAllItemsInTheBasket() throws Exception {
		Basket basket = new Basket();
		ManageItem item1 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		ManageItem item2 = new ManageItemImpl(Fruits.APPLE, Fruits.APPLE_PRICE);
		ManageItem item3 = new ManageItemImpl(Fruits.ORANGE, Fruits.ORANGE_PRICE);
		ManageItem item4 = new ManageItemImpl(Fruits.BANANA, Fruits.BANANA_PRICE);
		ManageItem item5 = new ManageItemImpl(Fruits.LEMON, Fruits.LEMON_PRICE);
		ManageItem item6 = new ManageItemImpl(Fruits.PEACH, Fruits.PEACH_PRICE);
		basket.addItem(item1);
		basket.addItem(item2);
		basket.addItem(item3);
		basket.addItem(item4);
		basket.addItem(item5);
		basket.addItem(item6);

		BigDecimal actual = cartProcessor.getTotalPrice(basket);
		BigDecimal expected = new BigDecimal(98);
		assertTrue(actual.compareTo(expected) == 0);

	}

	@Test(expected = BasketException.class)
	public void testTotalPriceWithNullItems() throws Exception {
		BigDecimal price = cartProcessor.getTotalPrice(null);
	}
}
