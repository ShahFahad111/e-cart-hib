package com.map.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.map.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
