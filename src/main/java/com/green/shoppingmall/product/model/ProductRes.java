package com.green.shoppingmall.product.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductRes {
  private ProductDetVo data;
    private List<String> pics;
}
