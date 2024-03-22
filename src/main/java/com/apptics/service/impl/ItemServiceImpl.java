package com.apptics.service.impl;

import com.apptics.dto.ItemDto;
import com.apptics.model.Item;
import com.apptics.repository.ItemRepository;
import com.apptics.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        //return all items
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemDtos = null;

        if (!items.isEmpty()) {
            ItemDto itemDto = null;
            itemDtos = new ArrayList<>();
            for (Item item : items) {
                itemDto = new ItemDto();
                BeanUtils.copyProperties(item, itemDto);
                itemDtos.add(itemDto);
            }
        }
        return itemDtos;
    }

    @Override
    public ItemDto getDetail(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        ItemDto itemDto = null;
        if (item != null) {
            itemDto = new ItemDto();
            BeanUtils.copyProperties(item, itemDto);
        }
        return itemDto;
    }

    @Override
    public ItemDto getDetailOptional(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        ItemDto itemDto = null;
        if(item.isPresent()){
            itemDto = new ItemDto();
            BeanUtils.copyProperties(item.get(), itemDto);
            //itemDto.setId(item.get().getId());
        }
        return itemDto;
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(itemDto.getName());
            item.setDescription(itemDto.getDescription());
            item.setPrice(itemDto.getPrice());
            item.setImageUrl(itemDto.getImageUrl());
            item.setUpdatedAt(LocalDateTime.now());
            itemRepository.save(item);
            BeanUtils.copyProperties(item, itemDto);
        }
        return itemDto;
    }

    @Override
    public ItemDto updateItemName(Long id, ItemDto itemDto) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(itemDto.getName());
            item.setUpdatedAt(LocalDateTime.now());
            itemRepository.save(item);
            BeanUtils.copyProperties(item, itemDto);
        }
        return itemDto;
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
