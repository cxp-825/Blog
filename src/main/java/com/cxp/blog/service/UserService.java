package com.cxp.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxp.blog.pojo.entity.User;
import com.cxp.blog.pojo.vo.LoginUserVo;
import com.cxp.blog.pojo.vo.RegisterUserVo;

/**
 * @author 煜之
 * @ClassName UserService
 * @Description TODO
 * @Date 2021/4/30 23:33
 * @Version 1.0
 **/
public interface UserService extends IService<User> {

    /**
     * 注册
     * @param vo
     * @return
     */
    String register(RegisterUserVo vo);

    /**
     * 登录
     * @param vo
     * @return
     */
    String login(LoginUserVo vo);
}
