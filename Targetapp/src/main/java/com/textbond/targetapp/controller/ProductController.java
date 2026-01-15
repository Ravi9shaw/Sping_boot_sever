package com.textbond.targetapp.controller;

import com.textbond.targetapp.dto.ProductCreateRequest;
import com.textbond.targetapp.model.Product;
import com.textbond.targetapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Product> createProduct(
            @ModelAttribute @Valid ProductCreateRequest request,
            @RequestParam MultipartFile image
    ) throws Exception {

        Product product = productService.createProduct(
                request.getName(),
                request.getPrice(),
                request.getSellerId(),
                image
        );

        return ResponseEntity.ok(product);
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<?> getProductsBySeller(
            @PathVariable String sellerId
    ) {
        return ResponseEntity.ok(
                productService.getProductsBySeller(sellerId)
        );
    }
}
