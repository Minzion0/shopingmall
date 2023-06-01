package com.green.shoppingmall.product.model;

import lombok.Data;

@Data
public class ProductInsDto {
    private Long iproduct;
    private Integer price;
    private String ctnt;
    private String createdAt;
    private String nm;
    private String brand;
}
