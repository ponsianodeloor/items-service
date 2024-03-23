package com.apptics.repository;

import com.apptics.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByNameContains(String name);
    //List<Item> findByNameAndDescription(String name, String description);
}
