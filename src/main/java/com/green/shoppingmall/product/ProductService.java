package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    private final ProductMapper mapper;
    @Autowired
    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }
    public int insProduct(MultipartFile multipartFile, ProductInsDto dto){
        ProductEntity entity = new ProductEntity();
        entity.setMainPic(dto.getBrand());
        entity.setNm(dto.getNm());
        entity.setPrice(dto.getPrice());
        entity.setCtnt(dto.getCtnt());

        String originalFilename = multipartFile.getOriginalFilename();

    }
}
