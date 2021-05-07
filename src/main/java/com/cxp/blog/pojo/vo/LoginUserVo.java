package com.cxp.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 煜之
 * @ClassName LoginUserVo
 * @Description TODO
 * @Date 2021/5/1 11:46
 * @Version 1.0
 **/
@Data
@ApiModel(description = "登录参数接收类")
public class LoginUserVo {

    @ApiModelProperty(value = "用户账号")
    private String userNo;
    @ApiModelProperty(value = "用户密码")
    private String userPwd;
}
