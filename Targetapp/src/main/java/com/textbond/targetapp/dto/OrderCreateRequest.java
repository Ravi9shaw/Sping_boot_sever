package com.textbond.targetapp.dto;

import jakarta.validation.constraints.NotBlank;
/*
So why is this Package  existing u thing
DTO stand for Data Transfer Object
A DTO is a class made ONLY to carry data between layers or systems
This like a ram to say
its for security purposs
 */
public class OrderCreateRequest {
    //Read Notifications in Model pacage to understand it
    @NotBlank(message = "ProductId is required")
    private String productId;

    @NotBlank(message = "BuyerId is required")
    private String buyerId;


    public OrderCreateRequest() {
    }


    public OrderCreateRequest(String productId, String buyerId) {
        this.productId = productId;
        this.buyerId = buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
