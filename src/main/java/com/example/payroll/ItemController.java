package com.example.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    private final CustomerRepository customerRepository;

    public ItemController(ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/{customer_id}/items")
    public ResponseEntity<List<Item>> getAllCommentsByTutorialId(@PathVariable Long customer_id) {
        if (!customerRepository.existsById(customer_id)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + customer_id);
        }
        List<Item> items = itemRepository.findAllByCustomerId(customer_id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
