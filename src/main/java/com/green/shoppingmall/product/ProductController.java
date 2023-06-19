package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.product.model.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int postProduct(@RequestPart  ProductInsDto dto,@RequestPart MultipartFile img){
        return service.insProduct(img,dto);
    }
    @PostMapping(value = "/{iproduct}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public   Long insProductPics(@PathVariable Long iproduct, @RequestPart List<MultipartFile> pics){

        try {
            return service.insProductPics(iproduct,pics);
        } catch (Exception e) {

            return 0L;
        }
    }
    @GetMapping
    public List<ProductVo> getProduct() {
        return service.selProduct();
    }







    //연습용
}
