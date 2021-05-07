package com.cxp.blog.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 煜之
 * @ClassName User
 * @Description TODO
 * @Date 2021/4/30 23:15
 * @Version 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象",description = "登录用户对象")
public class User {

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "账号")
    private String userNo;

    @ApiModelProperty(value = "密码（登录密码）")
    private String userPwd;
}
