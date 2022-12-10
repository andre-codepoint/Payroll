package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, ItemRepository itemRepository) {

        return args -> {
            Customer emp01=new Customer();
            emp01.setName("Little Bob");
            emp01.setRole(Role.USER);
            emp01.getItem().add(new Item( "iPhone", "Super magic iPhone 8g with custom case", 699, 3));
            emp01.getItem().add(new Item("Android Smartphone", "All day all weather for everybody Android Phone", 199, 4));
            emp01.getItem().add(new Item("Nokia 3310", "Oldschool 1g phone for hipster", 100, 1));
            customerRepository.save(emp01);

        };
    }
}
