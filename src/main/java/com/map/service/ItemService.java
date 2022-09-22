package com.map.service;

import java.util.List;

import com.map.model.dto.ItemDto;

public interface ItemService {

	ItemDto addItem(ItemDto itemDto);

	ItemDto getItem(Integer itemId);

	List<ItemDto> getAllItems();

	ItemDto updateItem(Integer itemId, ItemDto itemDto);

	void deleteItem(Integer itemId);

}
