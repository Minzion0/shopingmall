package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProTest;
import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public int postProduct(@RequestPart  ProductInsDto dto,@RequestPart MultipartFile img){
        return service.insProduct(img,dto);
    }
    //연습용
    @PostMapping(value = "/file",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int postgom(@RequestPart MultipartFile file, @RequestPart ProTest data){
        System.out.println("img = " + file.getOriginalFilename());
        System.out.println("data = " + data);
        return 0;
    }
}
