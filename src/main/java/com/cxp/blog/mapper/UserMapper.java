package com.cxp.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxp.blog.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 煜之
 * @ClassName UserMapper
 * @Description TODO
 * @Date 2021/4/30 23:31
 * @Version 1.0
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
