package com.map.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.exception.CartNotFoundException;
import com.map.model.Cart;
import com.map.model.dto.CartDto;
import com.map.repo.CartRepo;
import com.map.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CartDto addCart(CartDto cartDto) {
		return modelMapper.map(cartRepo.save(modelMapper.map(cartDto,Cart.class)), CartDto.class);
	}

	@Override
	public CartDto getCart(Integer cartId) {
		Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart :  ","with Id", cartId));
		return modelMapper.map(cart, CartDto.class);
	}

	@Override
	public List<CartDto> getAllCart() {
		List<Cart> list = cartRepo.findAll();
		List<CartDto> list2 = list.stream().map(i -> modelMapper.map(i, CartDto.class)).collect(Collectors.toList());
		return list2;
	}

	@Override
	public CartDto updateCart( Integer cartId,CartDto cartDto) {
		Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart :  ","with Id", cartId));
		cart.setName(cartDto.getName());
		Cart cart2 = cartRepo.save(cart);
		return modelMapper.map(cart2, CartDto.class);
	}

	@Override
	public void deleteCart(Integer cartId) {
		
		Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart :  ","with Id", cartId));
		cartRepo.delete(cart);

	}

}
