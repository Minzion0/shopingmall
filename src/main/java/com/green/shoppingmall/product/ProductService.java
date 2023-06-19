package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.product.model.ProductPicEntity;
import com.green.shoppingmall.product.model.ProductVo;
import com.green.shoppingmall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductMapper mapper;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public ProductService(ProductMapper mapper) {

        this.mapper = mapper;
    }

    public int insProduct(MultipartFile multipartFile, ProductInsDto dto) {

        String saveFileName = FileUtils.makeRandomFileNm(multipartFile.getOriginalFilename());

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
        if (!file.exists()) {
            file.mkdirs();
        }
        try {

            multipartFile.transferTo(file);
            return 1;
            //       multipartFile.transferTo(file);

        } catch (Exception e) {
            e.printStackTrace();
            file.delete();

        }
        return 0;
    }
    @Transactional(rollbackFor = Exception.class)
    public Long insProductPics(Long iproduct, List<MultipartFile> pics)throws Exception {
       List<ProductPicEntity> list=new ArrayList<>();

        String filePath = String.format("%s/product/%s/pics/", fileDir, iproduct);
        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        for(MultipartFile img : pics) {
            String savedFileNm = FileUtils.makeRandomFileNm(img.getOriginalFilename());
            System.out.println("savedFileNm : " + savedFileNm);

            File fileTarget = new File(String.format("%s/%s", filePath, savedFileNm));
            try {
                img.transferTo(fileTarget);
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("이미지 저장 실패");
            }

            ProductPicEntity entity = new ProductPicEntity();
            entity.setIproduct(iproduct);
            entity.setPic(savedFileNm);
            list.add(entity);
        }


        return  Long.valueOf(mapper.insproductPics(list));
    }
    List<ProductVo> selProduct() {
        return mapper.selProduct();
    }
}
