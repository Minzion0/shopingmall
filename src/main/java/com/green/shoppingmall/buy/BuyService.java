package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyEntity;
import com.green.shoppingmall.buy.model.BuyFindDto;
import com.green.shoppingmall.buy.model.BuyFindVo;
import com.green.shoppingmall.buy.model.BuyInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyService {
    private final BuyMapper mapper;

    public Long buyProduct(BuyInsDto dto){
        BuyEntity entity = new BuyEntity();
        entity.setIcustomer(dto.getIcustomer());
        entity.setQuantity(dto.getQuantity());
        entity.setIproduct(dto.getIproduct());
        mapper.insBuy(entity);
        return entity.getIbuy();
    }
    public List<BuyFindVo> findBuylist (BuyFindDto dto){
        return  mapper.findBuylist(dto);
    }
}
