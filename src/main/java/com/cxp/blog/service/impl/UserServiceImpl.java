package com.cxp.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxp.blog.mapper.UserMapper;
import com.cxp.blog.pojo.entity.User;
import com.cxp.blog.pojo.vo.LoginUserVo;
import com.cxp.blog.pojo.vo.RegisterUserVo;
import com.cxp.blog.service.UserService;
import com.cxp.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 煜之
 * @ClassName UserServiceImpl
 * @Description TODO 关于用户模块的功能（个人博客，注册可不用）
 * @Date 2021/4/30 23:34
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    private static final String USER_NO_TYPE = "101"; //定义生成账号的类型为纯数字
    /**
     * 登录
     * @param vo
     * @return
     */
    @Override
    public String login(LoginUserVo vo) {

        String loginResult = "";
        //以账号为条件查询数据库中用户信息
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("USER_NAME", vo.getUserNo());
        User user = userMapper.selectOne(userQueryWrapper);
        //比对登录信息是否与数据库中信息一致
        if (user != null && user.getUserNo().equals(vo.getUserNo()) && user.getUserPwd().equals(vo.getUserPwd())) {
            loginResult = "1";
        }else {
            loginResult = "0";
        }
        return loginResult;
    }

    /**
     * 用户注册 TODO：自用博客，可以不用注册，但还是实现一个注册功能
     * TODO：暂时先只插入账号密码
     * @param vo
     * @return
     */
    @Override
    public String register(RegisterUserVo vo) {

        User user = new User();
        //通过封装的ID生成器生成主键ID
        String userId = IdWorker.getStringID("CXP");
        String userNO;
        while (true) {
            //生成账号，并和数据库中数据比对，如果和数据库中重复，则重新生成账号
            userNO = IdWorker.getStringID(USER_NO_TYPE,10);
            User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("USER_NO", userNO));
            if (user1 != null) {
                break;
            }
        }
        BeanUtils.copyProperties(vo,user);
        user.setUserId(userId);
        user.setUserNo(userNO);
        int insertCount = userMapper.insert(user);
        return insertCount == 1 ? "注册成功！" : "注册失败！";
    }
}
