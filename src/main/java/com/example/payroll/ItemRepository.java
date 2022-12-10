package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCustomerId(Long itemId);
}
