package com.green.shoppingmall.buy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BuyFindVo {
    private Long ibuy;
    private Long iproduct;
    private String nm;
    private int price;
    private String mainPic;
    private Long icuetomer;
    private String cnm;
    private int quantity;
    private String buyAt;
}
