package com.lionel.mall.product.controller;

import com.lionel.mall.product.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(tags = "商品服务")
public class ProductController {

    @GetMapping("/list")
    @ApiOperation(value = "商品列表", httpMethod = "GET")
    public String list() {
        return "list";
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增商品", httpMethod = "POST")
    public String add() {
        Product product = new Product();
        System.out.println(product);
        return "add";
    }

    @DeleteMapping("/del")
    @ApiOperation(value = "删除商品", httpMethod = "DELETE")
    public String delete() {
        return "delete";
    }

}
