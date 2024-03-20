package com.apptics.controller;

import com.apptics.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    //add an item
    @PostMapping("/add")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto) {
        System.out.println("Item added: " + itemDto);
        return ResponseEntity.status(201).body(itemDto);
    }

    //get a list of items
    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getItems(){
        List<ItemDto> items = null;
        System.out.println("Items: " + items);
        return ResponseEntity.status(200).body(items);
    }

    //get an item by id
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long id){
        ItemDto item = null;
        return ResponseEntity.status(200).body(item);
    }

    //put an item
    @PutMapping("/{id}/update")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long id, @RequestBody ItemDto itemDto) {
        ItemDto item = null;
        return ResponseEntity.status(200).body(item);
    }

    //delete an item by id and name example: /api/v1/items/1?name=apple
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItem(@RequestParam Long id) {
        ItemDto item = null;
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return response;
    }

    //patch an item
    @PatchMapping("/title/{id}/update") //partial update of an item title
    public ResponseEntity<ItemDto> patchItemTitle(@RequestBody ItemDto itemDto) {
        return ResponseEntity.status(200).body(itemDto);
    }
}
