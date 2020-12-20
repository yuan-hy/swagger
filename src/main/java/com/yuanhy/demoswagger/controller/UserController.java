package com.yuanhy.demoswagger.controller;

import com.yuanhy.demoswagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhy
 * @date 2020-12-19 19:46
 */
@RestController
public class UserController {
    //接口中使用实体类，才会在 Swagger 的 Models 看得到
    @PostMapping("/user")
    public User getUser() {
        return new User("yuanhy", "123456");
    }
    @ApiOperation("对某个用户说 Hello")
    @GetMapping("/helloUser")
    public String sayHelloToUserNme(@ApiParam("用户名") String userName) {
        return "Hello, " + userName;
    }
}
