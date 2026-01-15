package com.textbond.targetapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//This one is same as Notification
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String productId;

    private String buyerId;

    private String paymentImagePath;

    private OrderStatus status;

    // ✅ Default constructor (required by Spring & Mongo)
    public Order() {
    }

    // ✅ Parameterized constructor (used by us)
    public Order(
            String productId,
            String buyerId,
            String paymentImagePath,
            OrderStatus status
    ) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.paymentImagePath = paymentImagePath;
        this.status = status;
    }

    // ✅ Getters & Setters
    public String getId() {
        return id;
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

    public String getPaymentImagePath() {
        return paymentImagePath;
    }

    public void setPaymentImagePath(String paymentImagePath) {
        this.paymentImagePath = paymentImagePath;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
