package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductMapper mapper;

    @Value("${file.dir}")
    private String fileDir;
    @Autowired
    public ProductService(ProductMapper mapper) {

        this.mapper = mapper;
    }
    public int insProduct(MultipartFile multipartFile, ProductInsDto dto){
        String .format("%s/",fileDir);


        String saveFileName = FileUtils.makeRandomFileNm(multipartFile.getOriginalFilename());
        String saveFilePath = fileDir + saveFileName;

       // File file = new File(saveFilePath);

        ProductEntity entity = ProductEntity.builder().nm(dto.getNm())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .mainPic(saveFileName)
                .ctnt(dto.getCtnt())
                .build();
        mapper.insProduct(entity);
        Long iproduct = entity.getIproduct();
        System.out.println("iproduct = " + iproduct);
        String format = String.format("%s/product/%s/", fileDir, iproduct);
        File file = new File(format + saveFileName);
        if (!file.exists()){
            file.mkdirs();
        }
        try {

            multipartFile.transferTo(file);
            return 1;
            //       multipartFile.transferTo(file);

        }catch (Exception e){
            e.printStackTrace();
            file.delete();

        }
        return 0;
    }
}
