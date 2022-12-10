package com.example.payroll;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerController {

    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/customers")
    Customer newEmployee(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    // Single item

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    Customer replaceEmployee(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setRole(newCustomer.getRole());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/customers/{id}/item/")
    @JsonView
    List<Item> items(@PathVariable Long id) {
            return repository.findAllById();

//        return repository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
    }

}