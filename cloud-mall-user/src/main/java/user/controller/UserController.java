package user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    @ApiOperation(value = "会员列表", httpMethod = "GET")
    public String list() {
        return "list";
    }

    @PostMapping("/add")
    @ApiOperation(value = "会员注册", httpMethod = "POST")
    public String add() {
        return "add";
    }

    @DeleteMapping("/del")
    @ApiOperation(value = "会员注销", httpMethod = "DELETE")
    public String delete() {
        return "delete";
    }

}
