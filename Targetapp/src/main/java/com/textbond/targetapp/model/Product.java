package com.textbond.targetapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//This same as Notfication
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private double price;

    // We Can Store images in DataBase servers as it big and makes it slow so we are Storing it address
    private String imagePath;

    private String sellerId;

    public Product() {
    }

    public Product(String name, double price, String imagePath, String sellerId) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.sellerId = sellerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getSellerId() {
        return sellerId;
    }
}
