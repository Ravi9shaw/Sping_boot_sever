package com.textbond.targetapp.service;

import com.textbond.targetapp.service.NotificationService;
import com.textbond.targetapp.dto.OrderCreateRequest;
import com.textbond.targetapp.model.Order;
import com.textbond.targetapp.model.OrderStatus;
import com.textbond.targetapp.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    public final NotificationService notificationService;

    private static final String UPLOAD_DIR =
            System.getProperty("user.home") + "/targetapp/uploads/payments/";
    // this here  System.getProperty("user.home") gives the actuall directrys users house

    public OrderService(OrderRepository orderRepository,NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public Order createOrder(
            OrderCreateRequest request,
            MultipartFile paymentImage
    ) throws IOException {
         // MultipartFile this is a object which spring gives us so that we can warp
        //the image to it(its done automatically) and the image is stored temoverly untily we diced what to do
        // 1️ Ensure payment directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        //  Generate unique filename
        String fileName = UUID.randomUUID() + "_" + paymentImage.getOriginalFilename();
        //this line genreates a randon name for use to use

        // Save payment image to disk
        File destination = new File(UPLOAD_DIR + fileName);
        //create a file where we r going to store the image
        paymentImage.transferTo(destination);

        //  Create Order object
        Order order = new Order(
                request.getProductId(),
                request.getBuyerId(),
                fileName,
                OrderStatus.PENDING
        );

        // Save to MongoDB
        return orderRepository.save(order);
    }

    public Order approveOrder(String orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.APPROVED);
        Order savedOrder = orderRepository.save(order);

        notificationService.createNotification(order.getBuyerId(),"Your order has been approved "+ order.getProductId() +" Was Approved");

        return savedOrder;
    }

    public Order rejectOrder(String orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.REJECTED);
        Order savedOrder = orderRepository.save(order);

        notificationService.createNotification(order.getBuyerId(),"You order for "+order.getProductId() +" has been rejected");

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByBuyer(String buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }

    public List<Order> getOrdersByProduct(String productId) {
        return orderRepository.findByProductId(productId);
    }

}
