package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/*
*   /customer 고객
*   (회원가입)
* */



@RestController
@Tag(name = "고객")
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;
    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입")
    private ResponseEntity<Integer> postCustomer(@RequestBody CustomerInsDto dto){
        int result = service.insCustomer(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<CustomerGetVo>>getCustomer(){
        return ResponseEntity.ok(service.selCustomer());
    }

}
