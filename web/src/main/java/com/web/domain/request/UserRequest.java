package com.web.domain.request;

import com.web.domain.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zhourui
 * @Date 2020/12/22 9:50
 */
@Data
@ApiModel(value = "用户请求")
public class UserRequest extends BaseRequest {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
}
