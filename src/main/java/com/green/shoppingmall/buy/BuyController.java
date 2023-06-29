package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.BuyFindDto;
import com.green.shoppingmall.buy.model.BuyFindVo;
import com.green.shoppingmall.buy.model.BuyInsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/buy")
@RequiredArgsConstructor
public class BuyController {
    private final BuyService service;

    @PostMapping
    public  Long postBuyProduct(@RequestBody BuyInsDto dto){

         return service.buyProduct(dto);
    }

    @GetMapping("/{icustomer}")
    public List<BuyFindVo> findBuylist (@PathVariable Long icustomer){
        BuyFindDto dto = new BuyFindDto();
        dto.setIcuestomer(icustomer);
        return service.findBuylist(dto);
    }
}
