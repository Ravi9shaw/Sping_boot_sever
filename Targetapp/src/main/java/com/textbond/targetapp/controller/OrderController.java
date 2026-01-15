package com.textbond.targetapp.controller;

import com.textbond.targetapp.dto.OrderCreateRequest;
import com.textbond.targetapp.model.Order;
import com.textbond.targetapp.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "multipart/form-data")
    //here consumes means here what type of data is been accepted here bro
    public ResponseEntity<Order> createOrder(
            @ModelAttribute @Valid OrderCreateRequest request,
            @RequestParam MultipartFile paymentImage
    ) throws Exception {

        Order order = orderService.createOrder(request, paymentImage);
    /*
    so let me say u @ModelAttribute this just map the input to the object input with there respected order input can be miss
    @Vail will check anyvaildation is applyed and if its approved
    u can skip it but we take it for better understanding
     */
        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}/approve")
    public ResponseEntity<Order> approveOrder(@PathVariable String orderId) {

        return ResponseEntity.ok(orderService.approveOrder(orderId));
    }

    @PatchMapping("/{orderId}/reject")
    public ResponseEntity<Order> rejectOrder(@PathVariable String orderId) {

        return ResponseEntity.ok(orderService.rejectOrder(orderId));
    }

    @GetMapping("/buyer/{buyerId}")
    public ResponseEntity<List<Order>> getOrdersByBuyer(
            @PathVariable String buyerId
    ) {
        return ResponseEntity.ok(orderService.getOrdersByBuyer(buyerId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Order>> getOrdersByProduct(
            @PathVariable String productId
    ) {
        return ResponseEntity.ok(orderService.getOrdersByProduct(productId));
    }


}
