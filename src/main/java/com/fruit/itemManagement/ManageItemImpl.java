package com.fruit.itemManagement;

import java.math.BigDecimal;

import com.fruit.exception.BasketException;

public class ManageItemImpl implements ManageItem {
	private String fruitname;
	private BigDecimal itemPrice;

	public ManageItemImpl(String fruitname, Double itemPrice) {
		if (fruitname == null || itemPrice == null) {
			throw new BasketException("Fruitname or price is null");
		}

		this.fruitname = fruitname;
		this.itemPrice = new BigDecimal(itemPrice);

	}

	@Override
	public boolean equals(Object o) {
		ManageItemImpl thisObj = (ManageItemImpl) o;
		return fruitname.equals(thisObj.fruitname);
	}

	@Override
	public int hashCode() {
		return fruitname.hashCode();
	}

	@Override
	public String getFruitName() {
		return this.fruitname;
	}

	@Override
	public BigDecimal getItemPrice() {
		return this.itemPrice;
	}

}
