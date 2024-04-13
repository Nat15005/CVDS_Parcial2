package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "ID")
    private int productId;
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "QUANTITY")
    private int quantity;

    public Product() {
    }

    public Product(int id, String name, String description, Category category, int rating, int price, int quantity) {
        this.productId = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}