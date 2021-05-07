package com.cxp.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 煜之
 * @ClassName UserVo
 * @Description TODO
 * @Date 2021/5/1 10:57
 * @Version 1.0
 **/

@Data
@ApiModel(description = "user接收类")
public class RegisterUserVo {

    @ApiModelProperty(value = "用户账号")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    private String userPwd;
}
