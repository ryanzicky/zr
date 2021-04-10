package com.web.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author zhourui
 * @Date 2020/12/22 11:03
 */
@Data
@Builder
@ApiModel(value = "用户返回类")
public class UserResponse {

    @ApiModelProperty(value = "id")
    private long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @ApiModelProperty(value = "是否删除")
    private int isRemove;
}
