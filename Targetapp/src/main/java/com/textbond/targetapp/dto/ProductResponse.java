package com.textbond.targetapp.dto;

public class ProductResponse {

    private String id;
    private String name;
    private double price;
    private String imageUrl;
    private String sellerId;

    public ProductResponse(
            String id,
            String name,
            double price,
            String imageUrl,
            String sellerId
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSellerId() {
        return sellerId;
    }
}
