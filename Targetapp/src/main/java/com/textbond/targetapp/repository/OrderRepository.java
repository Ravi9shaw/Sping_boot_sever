package com.textbond.targetapp.repository;

import com.textbond.targetapp.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/*
This common for all the Repository when u extend this to MongoRespositry u get some in built methord like save find remove etc
and if u make a function here its a SQL Quary so on call this function the sql quary is runed pls
when this class are loaded this things are made on runtime never exeictued use when we call it
 */
public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findByProductId(String productId);

    List<Order> findByBuyerId(String buyerId);
}
