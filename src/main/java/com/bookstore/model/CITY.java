package com.bookstore.model;

import java.math.BigDecimal;

public enum CITY {
	ISTANBUL(BigDecimal.valueOf(1.2)),ANKARA(BigDecimal.valueOf(1.3)),IZMIR(BigDecimal.valueOf(1.5));
	
	private BigDecimal bookStorePriceConstant;
	
	private CITY(BigDecimal bookStorePriceConstant){
		this.bookStorePriceConstant=bookStorePriceConstant;
	}

	public BigDecimal getBookStorePriceConstant() {
		return bookStorePriceConstant;
	}
}
