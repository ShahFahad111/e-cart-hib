package com.map.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.exception.ItemNotFoundException;
import com.map.model.Item;
import com.map.model.dto.ItemDto;
import com.map.repo.ItemRepo;
import com.map.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ItemDto addItem(ItemDto itemDto) {
		Item item = modelMapper.map(itemDto, Item.class);
		Item savedItem = itemRepo.save(item);
		return modelMapper.map(savedItem, ItemDto.class);
	}

	@Override
	public ItemDto getItem(Integer itemId) {
		System.out.println("Inside getItemMethod() itemId : " + itemId);
		Item item = itemRepo.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item ", "Not Found : ", itemId));
		System.out.println(item);
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public List<ItemDto> getAllItems() {
		List<Item> list = itemRepo.findAll();
		List<ItemDto> list2 = list.stream().map(i -> modelMapper.map(i, ItemDto.class)).collect(Collectors.toList());
		return list2;
	}

	@Override
	public ItemDto updateItem(Integer itemId, ItemDto itemDto) {
		Item item = itemRepo.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item ", "Not Found : ", itemId));
		item.setName(itemDto.getName());
		
		Item item2 = itemRepo.save(item);
		
		return modelMapper.map(item2, ItemDto.class);
	}

	@Override
	public void deleteItem(Integer itemId) {
		Item item = itemRepo.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item ", "Not Found : ", itemId));
		itemRepo.delete(item);
	}

}
