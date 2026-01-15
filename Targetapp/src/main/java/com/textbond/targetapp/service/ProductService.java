package com.textbond.targetapp.service;

import com.textbond.targetapp.dto.ProductResponse;
import com.textbond.targetapp.model.Product;
import com.textbond.targetapp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    private static final String UPLOAD_DIR =
            System.getProperty("user.home") + "/targetapp/uploads/products/";



    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(
            String name,
            double price,
            String sellerId,
            MultipartFile imageFile
    ) throws IOException {

        //  Ensure directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        //  Generate unique filename
        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

        // Save file to disk
        File destination = new File(UPLOAD_DIR + fileName);
        imageFile.transferTo(destination);

        // Save product to MongoDB
        Product product = new Product(
                name,
                price,
                 fileName,
                sellerId
        );

        return productRepository.save(product);
    }

    public List<ProductResponse> getProductsBySeller(String sellerId) {

        return productRepository.findBySellerId(sellerId)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        "http://localhost:8080/images/" + product.getImagePath(),
                        product.getSellerId()
                ))
                .toList();
    }

}
