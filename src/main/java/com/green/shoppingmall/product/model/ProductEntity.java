package com.green.shoppingmall.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductEntity {
    private Long iproduct;
    private Integer price;
    private String ctnt;
    private String createdAt;
    private String nm;
    private String mainPic;
    private String brand;
}
