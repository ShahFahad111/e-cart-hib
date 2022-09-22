package com.map.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
