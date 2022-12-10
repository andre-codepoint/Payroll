package com.example.payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

interface ItemRepository extends JpaRepository<Item, Long> {
}
