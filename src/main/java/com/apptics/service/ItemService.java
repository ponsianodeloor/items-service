package com.apptics.service;

import com.apptics.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    List<ItemDto> allItems();
    List<ItemDto> searchItemsByName(String name);
    List<ItemDto> searchItemsByNameWithConverter(String name);
    ItemDto getDetail(Long id);
    ItemDto getDetailOptional(Long id);
    ItemDto updateItem(Long id, ItemDto itemDto);
    ItemDto updateItemName(Long id, ItemDto itemDto);
    void deleteItem(Long id);
}
