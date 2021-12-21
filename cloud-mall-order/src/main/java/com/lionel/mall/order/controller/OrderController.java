package com.lionel.mall.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Api(tags = "订单")
public class OrderController {

    @GetMapping("/list")
    @ApiOperation(value = "订单列表", httpMethod = "GET")
    public String list() {
        return "list";
    }

    @PostMapping("/add")
    @ApiOperation(value = "生成订单", httpMethod = "POST")
    public String add() {
        return "add";
    }

    @DeleteMapping("/del")
    @ApiOperation(value = "取消订单", httpMethod = "DELETE")
    public String delete() {
        return "delete";
    }

}
