package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyEntity;
import com.green.shoppingmall.buy.model.BuyFindDto;
import com.green.shoppingmall.buy.model.BuyFindVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {

    int insBuy(BuyEntity entity);
    List<BuyFindVo> findBuylist (BuyFindDto dto);
}
