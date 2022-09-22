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

import com.map.model.dto.ItemDto;
import com.map.service.ItemService;
import com.map.util.ApiResponse;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/add/")
	public ResponseEntity<ItemDto> addItem(@RequestBody @Valid ItemDto itemDto){
		
		ItemDto item = itemService.addItem(itemDto);
		return new ResponseEntity<ItemDto>(itemDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{itemId}/")
	public ResponseEntity<ItemDto> getItem( @PathVariable("itemId") Integer ItemId){
		ItemDto itemDto = itemService.getItem(ItemId);
		return new ResponseEntity<ItemDto>(itemDto,HttpStatus.OK);
	}
	
	@GetMapping("/getAll/")
	public ResponseEntity<List<ItemDto>> getItem(){
		List<ItemDto> allItems = itemService.getAllItems();
		return new ResponseEntity<List<ItemDto>>(allItems,HttpStatus.OK);
	}
	
	@PutMapping("/update/{itemid}/")
	public ResponseEntity<ItemDto> updateItem(@RequestBody @Valid ItemDto itemDto, @PathVariable("itemId") Integer itemId){
		ItemDto updateItem = itemService.updateItem(itemId, itemDto);
		return new ResponseEntity<ItemDto>(updateItem,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<ApiResponse> deleteItem( @PathVariable("itemId") Integer itemId){
		itemService.deleteItem(itemId);
		ApiResponse response = new ApiResponse("Item id : " + itemId + " Deleted Successfully", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
}
