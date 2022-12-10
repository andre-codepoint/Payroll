package com.example.payroll;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    private final CustomerRepository repository;

    public ItemController(ItemRepository itemRepository, CustomerRepository repository) {
        this.itemRepository = itemRepository;
        this.repository = repository;
    }
}
