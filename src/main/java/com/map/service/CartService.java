package com.map.service;

import java.util.List;

import com.map.model.dto.CartDto;

public interface CartService {

	CartDto addCart(CartDto cartDto);
	
	CartDto getCart(Integer cartId);
	
	List<CartDto> getAllCart();
	
	CartDto updateCart(Integer cartId, CartDto cartDto);
	
	void deleteCart(Integer cartId);
	
}
