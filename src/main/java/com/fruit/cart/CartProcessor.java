package com.fruit.cart;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import com.fruit.exception.BasketException;
import com.fruit.itemManagement.ManageItem;

public class CartProcessor {

	public BigDecimal getTotalPrice(Basket basket) {
		if (basket == null) {
			throw new BasketException("invalid basket");
		}

		Map<ManageItem, Integer> items = basket.getItems();

		BigDecimal total = new BigDecimal(0);

		for (Entry<ManageItem, Integer> entry : items.entrySet()) {
			total = total.add((entry.getKey().getItemPrice().multiply(new BigDecimal(entry.getValue()))));
		}

		return total;
	}

}
