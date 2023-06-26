package com.green.shoppingmall.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDetVo {
    private Long iproduct;
    private int price;
    private String nm;
    private String ctnt;
    private String mainPic;
    private String brand;
}
