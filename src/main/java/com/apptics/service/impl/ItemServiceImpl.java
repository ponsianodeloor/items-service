package com.apptics.service.impl;

import com.apptics.dto.ItemDto;
import com.apptics.model.Item;
import com.apptics.repository.ItemRepository;
import com.apptics.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDto, item);

        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());

        item =  itemRepository.save(item);
        BeanUtils.copyProperties(item, itemDto);

        itemDto.setId(item.getId());

        return itemDto;
    }

    @Override
    public List<ItemDto> allItems() {
        return null;
    }

    @Override
    public ItemDto getDetail(Long id) {
        return null;
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        return null;
    }

    @Override
    public ItemDto updateItemTitle(Long id, ItemDto itemDto) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {

    }
}
