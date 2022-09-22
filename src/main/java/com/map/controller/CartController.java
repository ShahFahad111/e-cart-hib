package com.map.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.model.dto.CartDto;
import com.map.service.CartService;
import com.map.util.ApiResponse;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<CartDto> addCart(@RequestBody @Valid CartDto cartDto){
		
		CartDto cart = cartService.addCart(cartDto);
		return new ResponseEntity<CartDto>(cartDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{cartId}")
	public ResponseEntity<CartDto> getCart( @PathVariable("cartId") Integer cartId){
		CartDto cartDto = cartService.getCart(cartId);
		return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CartDto>> getCart(){
		List<CartDto> allcarts = cartService.getAllCart();
		return new ResponseEntity<List<CartDto>>(allcarts,HttpStatus.OK);
	}
	
	@PutMapping("/update/{cartId}")
	public ResponseEntity<CartDto> updateCart(@RequestBody @Valid CartDto cartDto, @PathVariable("cartId") Integer cartId){
		CartDto updatecart = cartService.updateCart(cartId, cartDto);
		return new ResponseEntity<CartDto>(updatecart,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<ApiResponse> deleteCart( @PathVariable("cartId") Integer cartId){
		cartService.deleteCart(cartId);
		ApiResponse response = new ApiResponse("cart id : " + cartId + " Deleted Successfully", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
}
