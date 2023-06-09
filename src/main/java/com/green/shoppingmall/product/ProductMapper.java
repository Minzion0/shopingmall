package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int insProduct(ProductEntity entity);
    int insproductPics(List<ProductPicEntity> entities);
    List<ProductVo> selProduct();
    List<String> selDetProduct(Long iproduct);
    ProductDetVo selProductDetal(Long iproduct);
}
