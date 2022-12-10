package com.example.payroll;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NonNull String title;

    private String description;

    private @NonNull Integer price;

    private @NonNull Integer quantity;

    public  Item() {
    }

    public Item(String title, String description, Integer price, Integer quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public Integer getPrice() {
        return price;
    }

    public void setPrice(@NonNull Integer price) {
        this.price = price;
    }

    @NonNull
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(getId(), item.getId()) && getTitle().equals(item.getTitle()) && Objects.equals(getDescription(), item.getDescription()) && getPrice().equals(item.getPrice()) && getQuantity().equals(item.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
