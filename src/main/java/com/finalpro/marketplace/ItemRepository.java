package com.finalpro.marketplace;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCustomerId(Long itemId);
}
