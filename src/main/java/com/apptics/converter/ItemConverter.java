package com.apptics.converter;

import com.apptics.dto.ItemDto;
import com.apptics.model.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {
    public ItemDto convertEntity2Dto(Item ie){
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(ie, itemDto);
        itemDto.setId(ie.getId());
        return itemDto;
    }
}
