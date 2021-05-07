package com.cxp.blog.controller;

import com.cxp.blog.pojo.vo.LoginUserVo;
import com.cxp.blog.pojo.vo.RegisterUserVo;
import com.cxp.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @ClassName UserController
 * @Description TODO
 * @Date 2021/4/30 22:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册
     * @param vo
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public String register(@RequestBody RegisterUserVo vo) {
        return userService.register(vo);
    }

    /**
     * 登录
     * @param vo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String login(@RequestBody LoginUserVo vo) {
        return userService.login(vo);
    }

}
