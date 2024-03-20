package com.apptics.service;

import com.apptics.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    List<ItemDto> allItems();
    ItemDto getDetail(Long id);
    ItemDto getDetailOptional(Long id);
    ItemDto updateItem(Long id, ItemDto itemDto);
    ItemDto updateItemTitle(Long id, ItemDto itemDto);
    void deleteItem(Long id);
}
